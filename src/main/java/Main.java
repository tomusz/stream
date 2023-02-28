import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    static BiFunction<String, Set<String>, String> processPropertiesSecurely = (providedProperty, requiredEncodedProp) ->
            requiredEncodedProp.contains(providedProperty) ? "******" : providedProperty;
    static String[] sensualKeys = {"login","password","url"};
    static Set<String> shouldBeEncoded = Arrays.stream(sensualKeys).collect(Collectors.toSet());
    public static void main(String[] args) {
        //TODO: code to ******
        //TODO: easy setting what should be coded by user use scanner with ; char separated
        //TODO: class to gather input from user
        //TODO:
        //TODO: validation
        //TODO: validation is list not empty
        //TODO: properties holder
        //TODO: securedValues holder
        //TODO: method to encode values with streams
//        Map<String, String> properties = new HashMap();
//        properties.put("login", "Angelina");
//        properties.put("password", "angelinaInHollywood123");
//        properties.put("title", "Salt");
//        properties.put("url", "www.angelina.hollywood");
//        properties.put("errorMessage", "file has not been founded");
        Properties properties = PropertiesProvider.getProperties();
        Map<String, String> appProperties = getAppProperties(properties);
        appProperties.forEach((k,v) -> System.out.println(k + " [" + v + "]"));
//        System.out.println(appProperties.toString());
    }
    public static Map<String, String> getAppProperties(Properties properties) {
        return properties.entrySet().stream()
                .map(x -> new KeyValuePair((String) x.getKey(),
                        (processPropertiesSecurely.apply((String) x.getKey(),shouldBeEncoded))))
                .collect(Collectors.toMap(KeyValuePair::getKey, KeyValuePair::getValue));
    }
}