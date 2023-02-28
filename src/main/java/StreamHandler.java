import java.util.Arrays;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class StreamHandler {

    static BiFunction<String, Set<String>, String> processPropertiesSecurely = (providedProperty, requiredEncodedProp) ->
            requiredEncodedProp.contains(providedProperty) ? "******" : providedProperty;

    public static Set<String> convertUserInput(String userInput) {
        return Arrays.stream(userInput.split(";")).collect(Collectors.toSet());
    }

}
