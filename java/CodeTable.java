package algorithms.haffman.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Кодовая таблица символов.
 */
class CodeTable {

    private final Map<String, Character> codeTable;

    CodeTable(){
        codeTable = new HashMap<>();
    }

    /**
     * Добавление ячейки таблицы
     * @param code двоичный код добавляемого символа
     * @param ch добавляемый в ячейку символ
     */
    void addCodeCell(String code, char ch){
        codeTable.put(code, ch);
    }

    /**
     * Возвращает код соответствующего символа из таблицы
     * @param ch запрашиваемый символ
     * @return строковое представление кода запрашиваемого символа
     */
    String getCode(char ch){
        return codeTable.keySet().stream().filter((String key) -> ch == codeTable.get(key)).findFirst().get();
    }
}