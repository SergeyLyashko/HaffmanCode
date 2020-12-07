package algorithms.haffman;

/**
 * Приоритетная очередь деревьев
 * @author Korvin
 */
class PriorityQueueTrees {

    private final Tree[] array;
    private int nElems;

    public PriorityQueueTrees(int maxSize){
        array = new Tree[maxSize];
    }

    // вставка деревьев с сортировкой
    void sortedTreeInsert(Tree tree){
        int i;
        if(nElems == 0){
            array[nElems++] = tree;
        }else{
            for(i=nElems-1; i>=0; i--){
                if(tree.getRootNode().getFrequencyValue() > array[i].getRootNode().getFrequencyValue()){
                    array[i+1] = array[i];
                }else{
                    break;
                }
            }
            array[i+1] = tree;
            nElems++;
        }
    }
    // извлечение наименее используемого элемента
    Tree remove(){
        return array[--nElems];
    }

    public boolean isEmpty(){
        return nElems == 0;
    }
}