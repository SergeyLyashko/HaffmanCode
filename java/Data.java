package algorithms.haffman.java;
import java.util.Scanner;

/**
 * Прием данных из консоли
 */
class Data {

    private final String inputText;

    Data(){
        System.out.println("Input text, please:");
        Scanner scan = new Scanner(System.in);
        inputText = scan.nextLine();
    }

    String getData(){
        return inputText;
    }
}