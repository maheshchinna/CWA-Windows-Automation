package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;

public class GetSetJSONData {

    static JSONParser jsonParser;
    static String filePath="src\\test\\java\\resources\\config.json";
    static Object object;
    static JSONObject jsonObject;

    private static void jsonSetUp() throws IOException, ParseException {
        jsonParser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        object =jsonParser.parse(reader);
        jsonObject = (JSONObject) object;
    }
    public static String getValue(String property) {
        String value = null;
        try {
            jsonSetUp();
            value=(String) jsonObject.get(property);
            System.out.println(value);
        }catch (Exception ex){
            System.out.println(ex+" Exception occurred");
        }
        return value;
    }

    // Write value to json file
    public static void setValue(String property,String value){
        FileWriter outputFile = null;
        try {
            jsonSetUp();
            outputFile =new FileWriter(filePath);
            jsonObject.put(property,value);
            outputFile.write(jsonObject.toString());
            outputFile.flush();
        }
        catch (Exception ex){
            System.out.println(ex+" Exception occurred");
        }
    }


}
