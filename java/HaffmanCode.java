package algorithms.haffman;

/**
 * Кодовая таблица Хаффмана
 * @author Korvin
 */
class HaffmanCode {

    private final CodeTable codeTable;
    private final String code = "";
    private FrequencyTable frequency;
    private HaffmanTree haffmanTree;
    private Node root;

    HaffmanCode(){
        codeTable = new CodeTable();
    }

    // кодирование текста
    String codeText(String text){
        createFrequencyTable(text);
        createHaffmanTree(frequency.getTable());
        //test вывод дерева
        //haffmanTree.getCodeTree().displayTree();
        root = haffmanTree.getCodeTree().getRootNode();
        addCodeToTable(root, code);
        return createCodeString();
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

    // создание таблицы частотности
    private void createFrequencyTable(String text) {
        frequency = new FrequencyTable(text);
    }
    // создание дерева Хаффмана
    private void createHaffmanTree(Node[] frequencyTable){
        haffmanTree = new HaffmanTree(frequencyTable);
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
