import java.util.Scanner;

public class UserInputProvider {

    private static final String WRONG_VALUE_PROVIDED ="""
    Allowed values are letters upper and lower case a to z
    Special character as separator is ;
    Example with one value: key
    Example with more then one value: key;key2;key3;key4""";

    public static String getInputFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getValidatedInputFromUser() {
        while (true) {
            System.out.println("In order to encode properties");
            System.out.println("Please provide one or more property key values. ");

        }
    }

}
