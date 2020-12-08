package algorithms.haffman.java;

/**
 * Приоритетная очередь деревьев
 * Создается для сортировки одноузловых деревьев по частоте
 * используемых элементов.
 */
class PriorityQueueTrees {

    private final Tree[] forest;
    // количество деревьев
    private int treeCount;

    public PriorityQueueTrees(int maxSize){
        forest = new Tree[maxSize];
    }

    /**
     * Сортировка элементов дерева по частоте используемых символов (узлов) текста,
     * где наибольшим приоритетом обладает наименее используемый символ.
     * @param tree дерево элементов
     */
    void sortedTreeInsert(Tree tree){
        int treeIndex;
        if(treeCount == 0){
            forest[treeCount++] = tree;
        }else{
            for(treeIndex = treeCount -1; treeIndex>=0; treeIndex--){
                if(tree.getRootNode().getFrequencyValue() > forest[treeIndex].getRootNode().getFrequencyValue()){
                    forest[treeIndex+1] = forest[treeIndex];
                }else{
                    break;
                }
            }
            forest[treeIndex+1] = tree;
            treeCount++;
        }
    }

    /**
     * Извлечение элемента (дерева) с наибольшим приоритетом
     * (т.о. наименее используемого в тексте) из очереди
     * @return дерево наибольшего приоритета
     */
    Tree remove(){
        return forest[--treeCount];
    }

    public boolean isEmpty(){
        return treeCount == 0;
    }
}