public class UserInputMsg {
    private static final String WRONG_VALUE_PROVIDED = """
                        
            Allowed values are letters upper and lower case a to z
            Allowed separator is ;
            Example with one value: key
            Example with more then one value: key;key2;key3;key4""";

    private static final String SCANNER_MESSAGE = """
                        
            In order to encode properties
            Please provide one or more property keys.""";

    public static String getWrongValueProvided() {
        return WRONG_VALUE_PROVIDED;
    }

    public static String getScannerMessage() {
        return SCANNER_MESSAGE;
    }
}