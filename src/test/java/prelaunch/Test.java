package prelaunch;

import utilities.PropertiesFile;

import java.io.File;
import java.io.IOException;

public class Test extends PropertiesFile {
    public static void main(String[] args) throws IOException {
        String uninstallCMD = System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe /silent /uninstall";
        Runtime.getRuntime().exec(uninstallCMD);
    }
}
