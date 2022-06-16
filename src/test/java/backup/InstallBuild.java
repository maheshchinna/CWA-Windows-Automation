package backup;

import java.io.IOException;

public class InstallBuild {

    public static void main(String[] args) throws IOException, InterruptedException {
        /*File file = new File( "lib","jacob-1.20-x64.dll");
        System.out.println(file.getAbsolutePath());
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
        AutoItX  autoit= new AutoItX();
        autoit.winWait("Citrix Workspace");*/

        // C:\Builds\CitrixWorkspaceApp.exe /includeSSON /includeappprotection /silent

        String command="C:\\Builds\\CitrixWorkspaceApp.exe /includeSSON /silent";

        Runtime.getRuntime().exec(command);

        do {
            System.out.println("Installing the build....");
            Thread.sleep(300000);
            System.out.println("Installing the build....");
        }while (false);
        //while(!(new File("").exists()));

        System.out.println("Installation passed");

    }

}