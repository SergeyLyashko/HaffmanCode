package algorithms.haffman.java;

/**
 * Код Хаффмана
 */
class HaffmanCode {

    private static final String DEFAULT_CODE = "";
    private final CodeTable codeTable;
    private Node root;
    private char[] textCharArray;

    HaffmanCode(){
        codeTable = new CodeTable();
    }

    /**
     * Кодирование входящего текста алгоритмом Хаффмана.
     * @param text входящий текст
     * @return закодированная строка в двоичном представлении.
     */
    String codeText(String text){
        FrequencyTable frequencyTable = createFrequencyTable(text);
        HaffmanTree haffmanTree = createHaffmanTree(frequencyTable);
        root = haffmanTree.getCodeTree().getRootNode();
        addCodeToCodeTable(root, DEFAULT_CODE);
        this.textCharArray = frequencyTable.getTextInCharArray();
        return buildCodeString();
    }

    // создание таблицы частотности
    private FrequencyTable createFrequencyTable(String text) {
        return new FrequencyTable(text);
    }

    // создание дерева Хаффмана из таблицы частотности
    private HaffmanTree createHaffmanTree(FrequencyTable frequencyTable){
        Node[] table = frequencyTable.getTable();
        return new HaffmanTree(table);
    }

    /**
     * Рекурсивный обход дерева Хаффмана, начиная с корня,
     * где в процессе перемещения к листовым узлам сохраняется выбор
     * направления на каждой "развилке".
     * @param localRoot корень дерева
     * @param code строящийся код в процессе рекурсивного вызова
     */
    private void addCodeToCodeTable(Node localRoot, String code){
        if(localRoot.isLeaf()){
            String current = code + localRoot.getCode();
            codeTable.addCodeCell(current, localRoot.getLetter());
            return;
        }
        code += localRoot.getCode();
        // рекурсивный вызов для левого потомка
        addCodeToCodeTable(localRoot.getLeftChild(), code);
        // рекурсивный вызов для правого потомка
        addCodeToCodeTable(localRoot.getRightChild(), code);
    }

    /**
     * Построение закодированной строки
     */
    private String buildCodeString(){
        StringBuilder builder = new StringBuilder();
        for(char ch : this.textCharArray){
            String tableCode = codeTable.getCode(ch);
            builder.append(tableCode);
        }
        return builder.toString();
    }

    /**
     * Вывод исходного текста в двоичном коде
     * @return двоичное представление исходного текста
     */
    String displayBinaryText(){
        StringBuilder builder = new StringBuilder();
        for(char ch : this.textCharArray){
            String binaryString = Integer.toBinaryString(ch);
            builder.append(binaryString);
        }
        return builder.toString();
    }

    /**
     * Декодирование входящего двоичного кода
     * @param code двоичное представление текста, закодированного
     *             кодом Хаффмана.
     * @return декодированный текст
     */
    String decodeText(String code){
        char[] binaryCodeArray = code.toCharArray();
        return decodeBuilder(binaryCodeArray);
    }

    /**
     * Построение строки из массива символов, представленных в виде
     * двоичного кода, перемещаясь по двоичному дереву (Хаффмана) к листовым узлам,
     * являющимися закодированными символами.
     * @param codeArray массив символов в двоичном представлении.
     * @return декодированный текст
     */
    private String decodeBuilder(char[] codeArray){
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
}
