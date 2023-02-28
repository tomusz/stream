import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    public static Properties getProperties() {
        try {
            return FileHandler.loadFile("webpage.properties");
        } catch (IOException e) {
            System.out.println("Properties file not found");
        }
        return null;
    }
}