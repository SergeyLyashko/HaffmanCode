package algorithms.haffman.java;

/**
 * Узел дерева
 */
class Node {

    private static final String DEFAULT_CODE = "";
    private Node leftChild;
    private Node rightChild;
    private char letter;
    private int frequency;
    private String code = DEFAULT_CODE;

    void setLeftChild(Node calculateCode){
        this.leftChild = calculateCode;
    }

    void setRightChild(Node right){
        this.rightChild = right;
    }

    void setLetter(char ch){
        this.letter = ch;
    }

    void setCode(String code){
        this.code = code;
    }

    String getCode(){
        return code;
    }

    void setFrequencyValue(int frequency){
        this.frequency = frequency;
    }

    char getLetter(){
        return letter;
    }

    int getFrequencyValue(){
        return frequency;
    }

    Node getLeftChild(){
        return leftChild;
    }

    Node getRightChild(){
        return rightChild;
    }

    boolean isLeaf(){
        return leftChild == null && rightChild == null;
    }
}