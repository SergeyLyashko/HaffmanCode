package algorithms.haffman.java;

import java.util.Arrays;

/**
 * Дерево Хаффмана
 */
class HaffmanTree {

    private Tree haffmanTree;

    HaffmanTree(Node[] frequencyTable){
        createOneNodeTreeForest(frequencyTable);
    }

    // создание леса 1-узловых деревьев из массива узлов
    private void createOneNodeTreeForest(Node[] frequencyTable) {
        Tree[] forest = new Tree[frequencyTable.length];
        Arrays.setAll(forest, (int i) -> new Tree(frequencyTable[i]));
        createPriorityQueue(forest);
    }

    // приоритетная очередь деревьев
    private void createPriorityQueue(Tree[] forest) {
        PriorityQueueTrees priorityQueue = new PriorityQueueTrees(forest.length);
        Arrays.stream(forest).forEach(priorityQueue::sortedTreeInsert);
        createHaffmanTree(priorityQueue);
    }

    // создние дерева Хаффмана
    private void createHaffmanTree(PriorityQueueTrees priorityQueue){
        while(!priorityQueue.isEmpty()){
            Tree one = priorityQueue.remove();
            Tree two;
            if(!priorityQueue.isEmpty()){
                two = priorityQueue.remove();
            }else{
                return;
            }
            Tree tree = new Tree();
            haffmanTree = tree.combineTree2in1(one, two);
            priorityQueue.sortedTreeInsert(haffmanTree);
        }
    }

    Tree getCodeTree(){
        return haffmanTree;
    }
}

