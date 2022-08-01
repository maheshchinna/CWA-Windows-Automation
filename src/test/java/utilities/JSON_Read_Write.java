package utilities;

public class JSON_Read_Write {

    static JSON_Handler json_obj;

    public static String getConfigValue(String property){
        json_obj= new JSON_Handler("config.json");
        return json_obj.getHandler(property);
    }
    static JSON_Handler json_obj2=new
            JSON_Handler("previous_run_info.json");

    public static String getRunValue(String property){
        return json_obj2.getHandler(property);
    }

    public static void setRunValue(String property, String value){
       json_obj2.setHandler(property,value);
    }


}
