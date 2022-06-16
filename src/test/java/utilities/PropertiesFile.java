package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    static Properties properties;
    static String filePath="src\\test\\java\\resources\\setup.properties";

    public static String read_properties(String property) throws IOException {
        properties =new Properties();
        FileInputStream inputFile=new FileInputStream(filePath);
        properties.load(inputFile);
        return properties.getProperty(property);
    }

    public static void write_properties(String property,String value) throws IOException {
        properties =new Properties();
        FileInputStream inputFile=new FileInputStream(filePath);
        properties.load(inputFile);
        properties.setProperty(property,value);
        FileOutputStream outputFile=new FileOutputStream(filePath);
        properties.store(outputFile,"Updated "+property+ " value");
    }

}
