package algorithms.haffman.java;

/**
 * Дерево
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

    /**
     * Преобразование 2 деревьев в 1 новое дерево с суммарной частотой
     * двух входных деревьев.
     * @return преобразованное дерево
     */
    Tree transform2in1(Tree oneTree, Tree twoTree){
        int frequencySum = oneTree.getRootNode().getFrequencyValue() + twoTree.getRootNode().getFrequencyValue();
        root.setFrequencyValue(frequencySum);

        // установка левого потомка
        Node left = setChildCode(oneTree, "0");
        root.setLeftChild(left);

        // установка правого потомка
        Node right = setChildCode(twoTree, "1");
        root.setRightChild(right);

        return this;
    }

    /**
     * Установка кода в корневой узел
     * @param tree дерево для преобразования
     * @param code код элемента
     * @return узел с кодом
     */
    private Node setChildCode(Tree tree, String code){
        Node node = tree.getRootNode();
        node.setCode(code);
        return node;
    }
}
