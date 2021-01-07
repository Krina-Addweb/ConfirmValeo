package Pages;
import com.aventstack.extentreports.ExtentTest;
import Actions.ActionClass;
import Actions.VerificationClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Pages.*;

import java.io.IOException;
import java.util.List;


public class ValeoReport {
    WebDriver driver;
    ExtentTest extentTest;

    @FindBy(how = How.XPATH,
            using = "//input[@id=\"edit-name\"]")
    private WebElement username_field;

    @FindBy(how = How.XPATH,
            using = "//input[@id=\"edit-pass\"]")
    private WebElement password_field;

    @FindBy(how = How.XPATH,
            using = "//input[@id=\"edit-submit\"]")
    private WebElement login_button;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"block-valeo-classic-account-menu\"]/div[2]/ul/li[6]")
    private WebElement logout_text;

    @FindBy(how = How.ID,
            using = "node/544096/title/en/full ")
    private WebElement WelcomeText;

    @FindBy(how = How.ID,
            using = "block-addcontent-2-menu")
    private WebElement AddNewRecode;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"block-valeo-classic-rateafasearches\"]/div[2]/ul/li[2]/ul/li[3]/a")
    private WebElement RatesbyFirmDetail;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"block-valeo-classic-page-title\"]/div[2]/h1")
    private WebElement RatesbyFirmDetailPageTitle;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_rate_firm_target_id_verf_chosen\"]/ul/li/input")
    private WebElement FirmField;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_rate_firm_target_id_verf_chosen\"]/div/ul/li/em")
    private WebElement Optionselect;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"views-exposed-form-search-rates-by-firm-detail-search-rates-by-firm-detail\"]/div/div[10]/label")
    private WebElement Position;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_term_node_tid_depth_position_chosen\"]/div/ul/li[3]")
    private WebElement SelectPosition;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_min_chosen\"]")
    private WebElement FromYear;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_min_chosen\"]/div/ul/li")
    private WebElement FromYearSelect;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_min_chosen\"]/div/div/input")
    private WebElement Searchbox;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_max_chosen\"]")
    private WebElement Toyear;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_max_chosen\"]/div/div/input")
    private WebElement ToyearSearch;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_max_chosen\"]/div/ul/li/em")
    private WebElement Toyearselect;

    @FindBy(how = How.XPATH,
            using = " //*[@id=\"edit-submit-search-rates-by-firm-detail\"]")
    private WebElement SearchBtn;

    public ValeoReport(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);
    }

    public void login() throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(driver,extentTest);
        Thread.sleep(2000);
        //driver.get("https://valeodev:F0rD3v0nly!@dev.reports.valeopartners.com/");
        actionClass.setValueinTextbox(username_field, "valeo_pinaldesai");
        Thread.sleep(3000);
        actionClass.setValueinTextbox(password_field, "valeo_pinaldesai");
        Thread.sleep(3000);
        actionClass.clickOnObject(login_button);
        Thread.sleep(5000);
        VerificationClass verificationClass = new VerificationClass(driver, extentTest);
        verificationClass.verifyTextPresent(logout_text, "Log out");
        actionClass.captureScreen("Login");
    }

    public void checkGraph() throws InterruptedException {
        ActionClass actionClass = new ActionClass(this.driver, extentTest);
        Thread.sleep(2000);
        driver.get("https://dev.reports.valeopartners.com/visual/test-report-3");
        Thread.sleep(5000);

        Boolean isGraph = driver.findElement(By.xpath("//*[@id=\"block-visualchartdisplay\"]/div[2]/div")).isDisplayed();
        if (isGraph = true) {
            extentTest.log(Status.PASS, "Graph is displayed");
            System.out.println("Graph is displayed");
        } else {
            extentTest.log(Status.FAIL, "Graph is not displayed");
            System.out.println("Graph not displayed");
        }
    }

    public void getReportData(String Firm, String rate_year, String rate_selection, String position) throws InterruptedException, IOException {
//      Report
        ActionClass actionClass = new ActionClass(this.driver, extentTest);
        Thread.sleep(2000);
        driver.get("https://dev.reports.valeopartners.com/rates/report");
        Thread.sleep(3000);
        actionClass.setValueinTextbox(this.FirmField,Firm);
        actionClass.clickOnObject(this.Optionselect);
        Thread.sleep(2000);
        actionClass.clickOnObject(this.Position);
        Thread.sleep(2000);
        actionClass.clickOnObject(this.SelectPosition);
        Thread.sleep(2000);
        actionClass.clickOnObject(this.FromYear);
        JavascriptExecutor jsetaskscore = (JavascriptExecutor) driver;
        jsetaskscore.executeScript("scrollBy(0,350)");
        actionClass.setValueinTextbox(this.Searchbox,rate_year);
        actionClass.clickOnObject(this.FromYearSelect);
        Thread.sleep(2000);
        actionClass.clickOnObject(this.ToyearSearch);
        actionClass.setValueinTextbox(this.ToyearSearch,rate_year);
        actionClass.clickOnObject(this.Toyearselect);
        actionClass.captureScreen("Filter selection");
        actionClass.clickOnObject(this.SearchBtn);
        Thread.sleep(4000);
        jsetaskscore.executeScript("scrollBy(0,450)");
        actionClass.captureScreen("Search result-1");
        Thread.sleep(1000);
        jsetaskscore.executeScript("window.scrollBy(600,0)");
        actionClass.captureScreen("Search result-2");

        POJO pojo = new POJO();

        String graduation_year = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[4]/table/tbody/tr[1]/td[12]")).getText();
        graduation_year.trim();
        if(graduation_year.isEmpty()){
            String rate_selection1 = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[4]/table/tbody/tr[1]/td[2]")).getText();
            System.out.println(rate_selection1);
            pojo.setRate_selection(rate_selection1);
            pojo.setPosition(position);
        }
        else {
            int year= Integer.parseInt(rate_year) - Integer.parseInt(graduation_year) + 1;
            if(year>=25){
                pojo.setPosition(position);
            }
            else {
                pojo.setPosition("Partner");
            }
        }
        String actual_rate1 = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[4]/table/tbody/tr[1]/td[16]")).getText();
        System.out.println(actual_rate1);
        pojo.setRate(actual_rate1);

        String report_rate_year = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[4]/table/tbody/tr[1]/td[19]")).getText();
        System.out.println(report_rate_year);
        pojo.setReportrateyear(report_rate_year);

//      Graph  Report
        driver.get("https://dev.reports.valeopartners.com/visual/test-report-3");
        Thread.sleep(3000);
        Boolean isGraph = driver.findElement(By.xpath("//*[@id=\"block-visualchartdisplay\"]/div[2]/div")).isDisplayed();
        if (isGraph = true) {
            extentTest.log(Status.PASS, "Graph is displayed");
            System.out.println("Graph is displayed");
            //POJO class
            //Get this value from the Searched Result page
            String rate_selection2 = driver.findElement(By.xpath("//*[@id=\"highcharts-data-table\"]/tbody/tr/td[1]")).getText();
            System.out.println(rate_selection2);

            if(pojo.getRate_selection().contains(rate_selection)  && rate_selection2.contains(rate_selection)){
                System.out.println("Rates selection are compared and are correct");
            }
            else{
                System.out.println("Rates selection are compared and are correct");
            }
//            String profile= "2020 - High";
//            String rate="$1,845";
            //Total elements
            List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"highcharts-data-table\"]/thead/tr/th"));
            int recordSize = list.size();

            //Graph value check comparing with the Listing page
            for (int i = 2; i < recordSize; i++) {
                String head_name = driver.findElement(By.xpath("//*[@id=\"highcharts-data-table\"]/thead/tr/th[" + i + "]")).getText();
//                System.out.println(head_name);
                System.out.println("Headname:"+head_name);
                System.out.println("pojo get postion:"+pojo.getPosition());

                if(head_name.equals(pojo.getPosition())) {
//                    System.out.println(pojo.getRate());
                    String actual_rate2= driver.findElement(By.xpath("//*[@id=\"highcharts-data-table\"]/tbody/tr/td["+i+"]")).getText();

                    System.out.println(i);
                    System.out.println(actual_rate2);
//                    if (pojo.getRate().contains(rate_value)){
                    if(pojo.getRate().contains(actual_rate2)){
                        System.out.println("Rates are compared and are correct");
                    }else {
                        System.out.println("Rates are compared and are not correct");
                    }
                    break;
                }
            }

        }else {
            extentTest.log(Status.FAIL, "Graph is not displayed");
            System.out.println("Graph not displayed");
        }
    }
}
