package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

 /*
 метод чтения значений из файла  .properties
 */

public class GetProperties {


       static String prop;

        public static String getProp(String key) {
            FileInputStream fileInputStream;
            Properties property = new Properties();

            try {
                fileInputStream = new FileInputStream("src/main/resources/driver.properties");
                property.load(fileInputStream);

                prop = property.getProperty(key);

            } catch (IOException e) {
                System.err.println("ОШИБКА: Файл свойств отсутствует!");
            }
            return prop;
        }
    }

