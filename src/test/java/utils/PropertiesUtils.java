package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    public static String readProperty(String property, String file){
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            properties.load(fileInputStream);
            return properties.getProperty(property);
        }catch (IOException ioException){
            System.err.println("Error loading properties file: " + file);
        }
        return null;
    }
}
