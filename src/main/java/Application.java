import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {

    private static final Properties hiddenProperties = PropertiesProvider.getProperties();
    private static Set<String> sensitiveProperties;
    private Map<String, String> availableProperties;

    private static boolean providedListIsNotEmpty(String inputFromScanner) {
        if (!UserInputValidation.isNotEmpty(inputFromScanner)) {
            return false;
        }
        sensitiveProperties = StreamHandler.convertUserInput(inputFromScanner);
        return true;
    }

    public void printMapKeyAndValues() {
        if (availableProperties == null) {
            System.out.println(CollectionsMsg.getProvideSensitivePropertiesMsg());
        } else {
            availableProperties.forEach((k, v) -> System.out.println(k + " [" + v + "]"));
        }
    }

    public void provideSensitivePropertiesKeys() {
        String inputFromScanner = "";
        while (!UserInputValidation.isMatchingExpectedInputPattern(inputFromScanner)) {
            System.out.println(UserInputMsg.getScannerMessage());
            System.out.println(UserInputMsg.getWrongValueProvided());
            inputFromScanner = UserInputProvider.getInputFromScanner();
            providedListIsNotEmpty(inputFromScanner);
        }
    }

    public void encodeAppProperties() {
        availableProperties = hiddenProperties.entrySet().stream()
                .map(x -> new KeyValuePair((String) x.getKey(),
                        (StreamHandler.processPropertiesSecurely.apply((String) x.getKey(), sensitiveProperties))))
                .collect(Collectors.toMap(KeyValuePair::getKey, KeyValuePair::getValue));
    }

}
