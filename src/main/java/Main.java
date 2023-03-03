import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Main {


    private static final String HIDDEN_VALUE = "******";
    private static final Set<String> sensitiveKeyChain = PropertiesProvider.getSensitiveProperties()
            .entrySet().stream().map(x -> x.getKey().toString()).collect(toSet());
    private static final Predicate<String> isInSensitiveKeyChainSet = sensitiveKeyChain::contains;
    private static final Function<KeyValuePair, KeyValuePair> hideSensitiveProperties = x ->
            isInSensitiveKeyChainSet.test(x.getKey()) ?
                    new KeyValuePair(x.getKey(), HIDDEN_VALUE) :
                    new KeyValuePair(x.getKey(), x.getValue());
    private static final Properties allProperties = PropertiesProvider.getWebPageProperties();
    private static Map<String, String> availableProperties = new HashMap<>();

    public static void main(String[] args) {
        getAppProperties();
        printMapKeyAndValues();
        encodeAppProperties();
        printMapKeyAndValues();
    }

    public static void getAppProperties() {
        availableProperties = allProperties.entrySet().stream()
                .map(x -> new KeyValuePair((String) x.getKey(), (String) x.getValue()))
                .collect(Collectors.toMap(KeyValuePair::getKey, KeyValuePair::getValue));
    }

    public static void encodeAppProperties() {
        availableProperties = allProperties.entrySet().stream()
                .map(x -> hideSensitiveProperties.apply(
                        new KeyValuePair((String) x.getKey(), (String) x.getValue())))
                .collect(Collectors.toMap(KeyValuePair::getKey, KeyValuePair::getValue));
    }

    public static void printMapKeyAndValues() {
        if (availableProperties == null) {
            System.out.println(CollectionsMsg.getProvideSensitivePropertiesMsg());
        } else {
            availableProperties.forEach((k, v) -> System.out.println(k + " [" + v + "]"));
        }
    }
}