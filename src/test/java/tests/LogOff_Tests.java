package tests;

import org.testng.annotations.Test;
import java.io.IOException;

public class LogOff_Tests {

    @Test(dependsOnGroups = "launch_test")
    void logoffSessions() throws IOException {
        String allSessionLogoff = "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe -logoffSessions";
        Runtime.getRuntime().exec(allSessionLogoff);
        System.out.println("All sessions are logged-off");
    }

    @Test(priority = 1,dependsOnGroups = "login_test")
    void logoffCWAUser() throws IOException {
        String CWAUserLogoff = "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe -logoff";
        Runtime.getRuntime().exec(CWAUserLogoff);
        System.out.println("CWA Logoff passed");
    }
}
