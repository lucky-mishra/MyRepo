package runners;

import org.testng.annotations.AfterTest;
import util.RerunFile;

import java.io.IOException;

public class RerunGen {
    @AfterTest
    public void tearRerun() throws IOException {
        RerunFile.getRerunFile();
    }
}
