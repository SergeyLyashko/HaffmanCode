package algorithms.haffman;


class Main {
    public static void main(String[] args) {
        Data data = new Data();
        String inputText = data.getData();
        HaffmanCode haffmanCode = new HaffmanCode();
        String codeText = haffmanCode.codeText(inputText);

        String binary = haffmanCode.displayBinaryText();
        System.out.println("full binary: "+binary);
        int binaryLength = binary.length();
        System.out.println("full binary length: "+binaryLength);

        System.out.println("haffman code: "+codeText);
        int codeLength = codeText.length();
        System.out.println("haffman code length: "+codeLength);

        System.out.println("Compressed in: "+(binaryLength/(double)codeLength));

        String decodeText = haffmanCode.decodeText(codeText);
        System.out.println("decode: "+decodeText);


    }
}
