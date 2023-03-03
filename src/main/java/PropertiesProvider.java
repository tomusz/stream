import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    public static Properties getWebPageProperties() {
        return getProperties("webpage.properties");
    }

    public static Properties getSensitiveProperties() {
        return getProperties("sensitive.properties");
    }

    private static Properties getProperties(String path) {
        try {
            return FileHandler.loadFile(path);
        } catch (IOException e) {
            System.out.println("Properties file not found");
        }
        return null;
    }
}