package algorithms.haffman;
import java.util.Arrays;

/**
 * частотная таблица для данных
 * @author Korvin
 */
class FrequencyTable {
    private final char[] lettersArray;
    private Node[] table;
    private int tableElement;

    FrequencyTable(String input){
        this.lettersArray = input.toCharArray();
        createFrequencyTable();
    }
    // создание таблицы частотности
    private void createFrequencyTable(){
        Node newNode;
        for(int i=0; i<lettersArray.length; i++){
            int count = 1;
            for(int j=i+1; j<lettersArray.length-1; j++){
                if(lettersArray[i] == lettersArray[j]){
                    count++;
                }
            }
            if(i==0){
                newNode = new Node();
                newNode.setLetter(lettersArray[i]);
                newNode.setFrequencyValue(count);
                tableElement++;
                table = new Node[tableElement];
                table[0] = newNode;
            }else if(isNotContains(lettersArray[i])){
                tableElement++;
                Node[] newTable = new Node[tableElement];
                newNode = new Node();
                newNode.setLetter(lettersArray[i]);
                newNode.setFrequencyValue(count);
                System.arraycopy(table, 0, newTable, 0, table.length);
                newTable[table.length] = newNode;
                table = newTable;
            }
        }
    }
    // проверка на дубликаты
    private boolean isNotContains(char ch){
        return Arrays.stream(table).noneMatch((Node element) -> element.getLetter() == ch);
    }

    Node[] getTable(){
        return Arrays.copyOf(table, table.length);
    }

    char[] getTextInCharArray(){
        return Arrays.copyOf(lettersArray, lettersArray.length);
    }
}