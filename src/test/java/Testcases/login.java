package Testcases;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class login extends Basecase {
    @Test(priority = 1)
    public void subjectValidation() throws IOException, InterruptedException, SQLException {
        logger = extent.createTest("Check if admin is logged in");
    }
}