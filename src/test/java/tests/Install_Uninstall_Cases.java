package tests;

import install_uninstall.Uninstallation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import install_uninstall.Installation;

import java.io.IOException;

public class Install_Uninstall_Cases {

    @BeforeTest
    void install() throws IOException, InterruptedException {
        Installation.installation_cwa();
    }

    @AfterTest
    void uninstall() throws IOException, InterruptedException {
        Uninstallation.uninstall_cwa();
    }


}
