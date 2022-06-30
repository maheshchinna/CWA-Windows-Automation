import org.junit.Test;
import java.io.IOException;

public class UnitTest   {

    @Test
   public void sample() throws IOException, InterruptedException {

        String last = "3840";
        String latest = "3840";
        if (latest.equals(last)){
            System.out.println("No new build");
        }
        else {
            System.out.println("New build available");
        }

    }
}
