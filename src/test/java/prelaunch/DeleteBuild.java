package prelaunch;

import org.testng.annotations.AfterSuite;

import java.io.File;

public class DeleteBuild {

    @AfterSuite
    void deleteCWABuild(){

        File cwa_file = new File(System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe");

        if (cwa_file.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete");
        }
    }
}
