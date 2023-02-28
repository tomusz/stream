import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //TODO: code to ******
        //TODO: easy setting what should be coded by user use scanner with ; char separated
        //TODO: class to gather input from user
        //TODO:
        //TODO: validation
        //TODO: validation is list not empty
        //TODO:non of properties match provided by you
        //TODO: properties holder
        //TODO: securedValues holder
        //TODO: method to encode values with streams
//        Map<String, String> properties = new HashMap();
//        properties.put("login", "Angelina");
//        properties.put("password", "angelinaInHollywood123");
//        properties.put("title", "Salt");
//        properties.put("url", "www.angelina.hollywood");
//        properties.put("errorMessage", "file has not been founded");
        Set<String> expectedEncoded = StreamHandler.convertUserInput(UserInputProvider.getInputFromScanner());
        Properties properties = PropertiesProvider.getProperties();
        Map<String, String> appProperties = encodeAppProperties(properties,expectedEncoded);
        printMapKeyAndValues(appProperties);
    }
    public static Map<String, String> encodeAppProperties(Properties properties, Set<String> shouldBeEncoded) {
        return properties.entrySet().stream()
                .map(x -> new KeyValuePair((String) x.getKey(),
                        (StreamHandler.processPropertiesSecurely.apply((String) x.getKey(),shouldBeEncoded))))
                .collect(Collectors.toMap(KeyValuePair::getKey, KeyValuePair::getValue));
    }

    public static void printMapKeyAndValues(Map<String, String > map) {
        map.forEach((k,v) -> System.out.println(k + " [" + v + "]"));
    }
}