package algorithms.haffman;

import java.util.Arrays;

/**
 * Дерево Хаффмана
 * @author Korvin
 */
class HaffmanTree {

    private Tree haffmanTree;
    private final Node[] frequencyTable;
    private PriorityQueueTrees priorityQueue;

    HaffmanTree(Node[] frequencyTable){
        this.frequencyTable = frequencyTable;
        createOneNodeTreeForest();
        createHaffmanTree();
    }

    // создание леса 1-узловых деревьев из массива узлов
    private void createOneNodeTreeForest() {
        Tree[] forest = new Tree[frequencyTable.length];
        Arrays.setAll(forest, (int i) -> new Tree(frequencyTable[i]));
        createPriorityQueue(forest);
    }

    // приоритетная очередь деревьев
    private void createPriorityQueue(Tree[] forest) {
        priorityQueue = new PriorityQueueTrees(forest.length);
        Arrays.stream(forest).forEach(priorityQueue::sortedTreeInsert);
    }

    // создние дерева Хаффмана
    private void createHaffmanTree(){
        Tree one, two;
        while(!priorityQueue.isEmpty()){
            one = priorityQueue.remove();
            if(!priorityQueue.isEmpty()){
                two = priorityQueue.remove();
            }else{
                return;
            }
            Tree tree = new Tree();
            haffmanTree = tree.combineTreeWithFrequencySum(one, two);
            priorityQueue.sortedTreeInsert(haffmanTree);
        }
    }

    Tree getCodeTree(){
        return haffmanTree;
    }
}

