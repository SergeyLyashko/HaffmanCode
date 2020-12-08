package algorithms.haffman.java;

/**
 * Приоритетная очередь деревьев
 * Создается для сортировки деревьев по частоте
 * используемых элементов
 */
class PriorityQueueTrees {

    private final Tree[] forest;
    // количество деревьев
    private int treeCount;

    public PriorityQueueTrees(int maxSize){
        forest = new Tree[maxSize];
    }

    /**
     * Вставка деревьев и сортировка их по частоте
     * используемых элементов (символов) текста
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
     * Извлечение элемента (дерева) с наименьшим приоритетом
     * (наименее используемого в тексте) из очереди
     * @return дерево наименьшего приоритета
     */
    Tree remove(){
        return forest[--treeCount];
    }

    public boolean isEmpty(){
        return treeCount == 0;
    }
}