package algorithms.haffman;

/**
 * Узел
 * @author Korvin
 */
class Node {
    private Node leftChild;
    private Node rightChild;
    private char letter;
    private int frequency;
    private String code = "";

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

    void displayNode(){
        System.out.printf("{%s} ", letter);
    }
}