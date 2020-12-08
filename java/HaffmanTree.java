package algorithms.haffman.java;

import java.util.Arrays;

/**
 * Дерево Хаффмана.
 */
class HaffmanTree {

    private final Tree haffmanTree;

    HaffmanTree(Node[] frequencyTable){
        Tree[] forest = createOneNodeTreeForest(frequencyTable);
        PriorityQueueTrees priorityQueue = createPriorityQueue(forest);
        haffmanTree = createHaffmanTree(priorityQueue);
    }

    /**
     * Создание массива одноузловых деревьев из таблицы частотности
     * узлов.
     * @param frequencyTable таблица частотности.
     * @return массив одноузловых деревьев.
     */
    private Tree[] createOneNodeTreeForest(Node[] frequencyTable) {
        Tree[] forest = new Tree[frequencyTable.length];
        Arrays.setAll(forest, (int i) -> new Tree(frequencyTable[i]));
        return forest;
    }

    /**
     * Создание приоритетной очереди из массива деревьев для
     * сортировки деревьев по приоритету узловых элементов.
     * @param forest массив одноузловых деревьев.
     * @return приоритетная сортированная очередь одноузловых деревьев.
     */
    private PriorityQueueTrees createPriorityQueue(Tree[] forest) {
        PriorityQueueTrees priorityQueue = new PriorityQueueTrees(forest.length);
        Arrays.stream(forest).forEach(priorityQueue::sortedTreeInsert);
        return priorityQueue;
    }

    /**
     * Создание дерева Хаффмана путем построения дерева из извлеченных элементов
     * приоритетной очереди (деревьев) и объединения их в одно дерево,
     * с внесением, вновь образованного дерева, в приоритетную очередь.
     * Т.о. количество деревьев в приоритетной очереди сокращается, а деревья,
     * вставляемые в очередь растут.
     * Единственное оставшееся в очереди дерево является деревом Хаффмана.
     * @param priorityQueue приоритетная очередедь деревьев
     * @return дерево Хаффмана
     */
    private Tree createHaffmanTree(PriorityQueueTrees priorityQueue){
        Tree transformTree = null;

        while(!priorityQueue.isEmpty()){
            Tree one = priorityQueue.remove();
            Tree two;
            if(!priorityQueue.isEmpty()){
                two = priorityQueue.remove();
            }else{
                return transformTree;
            }
            Tree tree = new Tree();
            transformTree = tree.transform2in1(one, two);
            priorityQueue.sortedTreeInsert(transformTree);
        }

        return transformTree;
    }

    Tree getCodeTree(){
        return haffmanTree;
    }
}

