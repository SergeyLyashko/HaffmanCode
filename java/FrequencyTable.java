package algorithms.haffman.java;
import java.util.Arrays;

/**
 * Частотная таблица для данных
 */
class FrequencyTable {
    private final char[] lettersArray;
    private Node[] currentTable;
    private int tableElement;

    FrequencyTable(String input){
        this.lettersArray = input.toCharArray();
        createFrequencyTable();
    }

    // создание таблицы частотности
    private void createFrequencyTable(){
        for(int i=0; i<lettersArray.length; i++){
            int count = 1;
            // поиск количества одинаковых символов
            for(int j=i+1; j<lettersArray.length-1; j++){
                if(lettersArray[i] == lettersArray[j]){
                    count++;
                }
            }
            addTableElement(i, count);
        }
    }

    private void addTableElement(int index, int count){
        if(index==0){
            addStartElement(count);
        }else if(isNotContains(lettersArray[index])){
            addNewElement(index, count);
        }
    }

    private void addStartElement(int count){
        Node newNode = new Node();
        newNode.setLetter(lettersArray[0]);
        newNode.setFrequencyValue(count);
        tableElement++;
        currentTable = new Node[tableElement];
        currentTable[0] = newNode;
    }

    private void addNewElement(int index, int count){
        tableElement++;
        Node[] newTable = new Node[tableElement];
        Node newNode = new Node();
        newNode.setLetter(lettersArray[index]);
        newNode.setFrequencyValue(count);
        System.arraycopy(currentTable, 0, newTable, 0, currentTable.length);
        // последний элемент таблицы
        newTable[currentTable.length] = newNode;
        currentTable = newTable;
    }

    // проверка на дубликаты
    private boolean isNotContains(char ch){
        return Arrays.stream(currentTable).noneMatch((Node element) -> element.getLetter() == ch);
    }

    Node[] getTable(){
        return currentTable;
    }

    char[] getTextInCharArray(){
        return lettersArray;
    }
}