package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSON_Handler {
    JSONParser jsonParser;
    String filePath;
    Object object;
    JSONObject jsonObject;

    public JSON_Handler(String filePath) {
        this.filePath = filePath;
    }

    private void jsonSetUp() throws IOException, ParseException {
        jsonParser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        object =jsonParser.parse(reader);
        jsonObject = (JSONObject) object;
    }
    protected String getHandler(String property) {
        String value = null;
        try {
            jsonSetUp();
            value=(String) jsonObject.get(property);
            //System.out.println(value);
        }catch (Exception ex){
            LoggingHandler.log_error(ex+" Exception occurred");
        }
        return value;
    }

    // Write value to json file
    protected void setHandler(String property,String value){
        FileWriter outputFile;
        try {
            jsonSetUp();
            outputFile =new FileWriter(filePath);
            jsonObject.put(property,value);
            outputFile.write(jsonObject.toString());
            outputFile.flush();
        }
        catch (Exception ex){
            LoggingHandler.log_error(ex+" Exception occurred");
        }
    }
}
