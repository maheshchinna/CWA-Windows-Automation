import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.prefs.BackingStoreException;
import java.io.IOException;


public class UnitTest   {

    static JSONParser jsonParser;
    static String filePath="src\\test\\java\\resources\\config.json";
    @Test
    public static void TestSample() throws IOException, ParseException {

        jsonParser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        Object obj=jsonParser.parse(reader);
        //System.out.println(filePath);
        JSONObject testDataObj = (JSONObject)obj;
        System.out.println(testDataObj.get("url"));
       /* testDataObj.put("branch","22");

        FileWriter update=new FileWriter(filePath);
        update.write(testDataObj.toString());
        update.flush();
        update.close();*/

        }
    }


