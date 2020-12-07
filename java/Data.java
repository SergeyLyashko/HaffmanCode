package algorithms.haffman;
import java.util.Scanner;

/**
 * Прием данных из консоли
 * @author Korvin
 */
class Data {

    private final String inputText;

    // прием данных
    Data(){
        System.out.println("Input text, please:");
        Scanner scan = new Scanner(System.in);
        inputText = scan.nextLine();
    }

    String getData(){
        return inputText;
    }
}