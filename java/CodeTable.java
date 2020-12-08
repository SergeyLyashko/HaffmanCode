package algorithms.haffman.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Создание таблицы кодов
 */
class CodeTable {

    private final Map<String, Character> codeTable;

    CodeTable(){
        codeTable = new HashMap<>();
    }

    // добавление кода в таблицу
    void addCode(String code, char ch){
        codeTable.put(code, ch);
    }

    // получение символа по коду
    char getChar(String code){
        return codeTable.get(code);
    }

    // получение кода по символу
    String getCode(char ch){
        return codeTable.keySet().stream().filter((String key) -> ch == codeTable.get(key)).findFirst().get();
    }
}