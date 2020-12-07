package algorithms.haffman;

import java.util.Stack;
/**
 * Дерево
 * @author Korvin
 */
class Tree {
    private final Node root;

    Tree(){
        root = new Node();
    }

    Tree(Node node){
        root = node;
    }

    Node getRootNode(){
        return root;
    }

    // комбинирование 2 деревьев в 1 с суммарной частотой
    Tree combineTreeWithFrequencySum(Tree one, Tree two){
        int frequencySum = one.getRootNode().getFrequencyValue() +
                two.getRootNode().getFrequencyValue();

        root.setFrequencyValue(frequencySum);
        root.setLetter('*');
        // левое поддерево
        Node oneNode = one.getRootNode();
        oneNode.setCode("0");
        root.setLeftChild(oneNode);
        // правое подерево
        Node twoNode = two.getRootNode();
        twoNode.setCode("1");
        root.setRightChild(twoNode);
        return this;
    }

    // вывод дерева на экран
    void displayTree(){
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "....................................................................");
        while(isRowEmpty == false){
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++){
                System.out.print(' ');
            }
            while(globalStack.isEmpty() == false){
                Node temp = globalStack.pop();
                if(temp != null){
                    if(temp.isLeaf()){
                        System.out.print(temp.getLetter());
                        System.out.print("<"+temp.getCode()+">");
                    }else{
                        System.out.print(temp.getLetter());
                        System.out.print("<"+temp.getCode()+">");
                    }
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());

                    if(temp.getLeftChild()!= null || temp.getRightChild()!= null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("  ");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++){
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty() == false){
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(
                "....................................................................");
    }
}
