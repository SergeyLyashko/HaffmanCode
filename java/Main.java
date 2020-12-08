package algorithms.haffman.java;


class Main {
    public static void main(String[] args) {
        Data data = new Data();
        String inputText = data.getData();
        if(!inputText.isEmpty()) {
            HaffmanCodeTable haffmanCodeTable = new HaffmanCodeTable();
            String codeText = haffmanCodeTable.codeText(inputText);
            System.out.println("haffman code: " + codeText);
            int codeLength = codeText.length();
            System.out.println("haffman code length: " + codeLength);

            String binary = haffmanCodeTable.displayBinaryText();
            System.out.println("full binary: " + binary);
            int binaryLength = binary.length();
            System.out.println("full binary length: " + binaryLength);

            System.out.println("Compressed in: " + (binaryLength / (double) codeLength));

            String decodeText = haffmanCodeTable.decodeText(codeText);
            System.out.println("decode test: " + decodeText);
        }
    }
}
