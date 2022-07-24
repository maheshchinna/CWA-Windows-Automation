import utilities.GetSetJSONData;
import utilities.ScreenRecorderUtil;
import java.io.IOException;

public class UnitTest  extends GetSetJSONData {

    public static void main(String[] args) throws Exception {
        ScreenRecorderUtil.startRecord("Demo");
        testSample();
        ScreenRecorderUtil.stopRecord();
    }

    public static void testSample() throws InterruptedException, IOException {
        System.out.println("Test");
        Thread.sleep(5000);
        System.out.println("Hi");
    }
}

