package reusable.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static Properties properties;
    public static void usage() throws IOException {
        properties = new Properties();
        String propPath = System.getProperty("user.dir") + "//src//test//java//reusable//com//inspect.properties";
        FileInputStream fileInputStream = new FileInputStream(propPath);
        properties.load(fileInputStream);
    }
}
