import java.util.regex.Pattern;

public class UserInputValidation {

    private final static Pattern EXPECTED_INPUT_PATTERN = Pattern.compile("^[a-zA-Z]+(;[a-zA-Z]+)*");

    public static boolean isMatchingExpectedInputPattern(String input) {
        return input.matches(EXPECTED_INPUT_PATTERN.toString());
    }

    public static boolean isNotEmpty(String string) {
        return !string.replaceAll(" ", "").isEmpty();
    }
}