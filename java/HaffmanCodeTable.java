package algorithms.haffman.java;

/**
 * Кодовая таблица Хаффмана
 */
class HaffmanCodeTable {

    private static final String DEFAULT_CODE = "";
    private final CodeTable codeTable;
    private FrequencyTable frequency;
    private HaffmanTree haffmanTree;
    private Node root;

    HaffmanCodeTable(){
        codeTable = new CodeTable();
    }

    // кодирование текста
    String codeText(String text){
        createFrequencyTable(text);
        createHaffmanTree(frequency.getTable());
        root = haffmanTree.getCodeTree().getRootNode();
        addCodeToTable(root, DEFAULT_CODE);
        return createCodeString();
    }

    // создание таблицы частотности
    private void createFrequencyTable(String text) {
        frequency = new FrequencyTable(text);
    }

    // создание дерева Хаффмана
    private void createHaffmanTree(Node[] frequencyTable){
        haffmanTree = new HaffmanTree(frequencyTable);
    }

    // кодирование текста в таблицу
    private void addCodeToTable(Node localRoot, String code){
        if(localRoot.isLeaf()){
            this.codeTable.addCode(code+localRoot.getCode(), localRoot.getLetter());
            return;
        }
        code += localRoot.getCode();
        addCodeToTable(localRoot.getLeftChild(), code);
        addCodeToTable(localRoot.getRightChild(), code);
    }

    // декодирование текста
    String decodeText(String code){
        char[] binaryCodeArray = code.toCharArray();
        return decoding(binaryCodeArray);
    }

    // декодирование текста
    private String decoding(char[] codeArray){
        StringBuilder builder = new StringBuilder();
        Node localRoot = root;
        for (char ch : codeArray) {
            if (ch == '0') {
                localRoot = localRoot.getLeftChild();
            }
            if (ch == '1') {
                localRoot = localRoot.getRightChild();
            }
            if (localRoot.isLeaf()) {
                builder.append(localRoot.getLetter());
                localRoot = root;
            }
        }
        return builder.toString();
    }

    // кодирование
    private String createCodeString(){
        char[] charArray = frequency.getTextInCharArray();
        StringBuilder builder = new StringBuilder();
        for(char ch : charArray){
            String tableCode = codeTable.getCode(ch);
            builder.append(tableCode);
        }
        return builder.toString();
    }

    // вывод текста в двоичном коде (без сжатия)
    String displayBinaryText(){
        char[] charArray = frequency.getTextInCharArray();
        StringBuilder builder = new StringBuilder();
        for(char ch : charArray){
            String binaryString = Integer.toBinaryString(ch);
            builder.append(binaryString);
        }
        return builder.toString();
    }
}
