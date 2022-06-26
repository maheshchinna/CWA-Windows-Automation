import org.junit.Test;
import java.io.IOException;

public class UnitTest   {

    @Test
   public void sample() throws IOException, InterruptedException {

        String[] enableDevMode = {"regedit", "/s", System.getProperty("user.dir")+"\\Dependencies\\devModeOn.reg"};
        Runtime.getRuntime().exec(enableDevMode);
        Thread.sleep(2000);
        System.out.println("Dev Mode enabled");

        String installWinAppDriver = System.getProperty("user.dir")+"\\Dependencies\\WindowsApplicationDriver-1.2.99-win-x64.exe /silent";
        Runtime.getRuntime().exec(installWinAppDriver);
        Thread.sleep(90000);
        System.out.println("Win App Driver installed");

    }
}
