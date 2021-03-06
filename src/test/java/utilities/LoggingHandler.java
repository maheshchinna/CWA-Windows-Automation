package utilities;

import org.testng.log.TextFormatter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingHandler {

    static Logger logger;
    static FileHandler handler;

    public static void createFile() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH.mm");
        try {
            handler = new FileHandler("logs/automation_executed_on_" + dateFormat.format(new Date()) + ".log", true);
            log_handler();
        }
        catch (IOException exp){
            exp.printStackTrace();
        }
    }

    private static void log_handler()  {
        logger = Logger.getLogger("MyLog");
        logger.addHandler(handler);
        SimpleFormatter formatter = new TextFormatter();
        handler.setFormatter(formatter);
    }

    public static void log_info(String infoMsg) {
        logger.info("INFO  :"+infoMsg);

    }
    public static void log_error(String warnMsg) {
        logger.warning("ERROR :"+warnMsg);
    }
}
