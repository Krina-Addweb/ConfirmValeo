package Testcases;

import Pages.ValeoReport;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestValeoReport extends Basecase{
    @Test(priority = 1)
    public void Adminlogin() throws IOException, InterruptedException {
        logger = extent.createTest("Check if admin is logged in");
        ValeoReport valeoReport = new ValeoReport(driver, logger);
        valeoReport.login();
    }

    @Test(priority = 2)
    public void graphCheck() throws IOException, InterruptedException {
        logger = extent.createTest("Check if the graph is present on the Graph page");
        ValeoReport valeoReport = new ValeoReport(driver, logger);
        valeoReport.checkGraph();
    }

    @Test(priority = 3)
    public void reportData() throws IOException, InterruptedException {
        logger = extent.createTest("Check if the graph values and report values are same or not");
        ValeoReport valeoReport = new ValeoReport(driver, logger);
        valeoReport.getReportData("Kirkland & Ellis LLP", "2020", "High", "Senior Partner");
    }
}
