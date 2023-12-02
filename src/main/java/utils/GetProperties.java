package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

 /*
 метод чтения значений из файла  .properties
 */

public class GetProperties {

    public static String getProp(String key) throws IOException {
        File file = new File("src/main/resources/driver.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));
        String prop = properties.getProperty(key);
        return prop;
    }
}
