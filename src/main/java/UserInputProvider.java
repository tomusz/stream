import java.util.Scanner;

public class UserInputProvider {

    public static String getInputFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}