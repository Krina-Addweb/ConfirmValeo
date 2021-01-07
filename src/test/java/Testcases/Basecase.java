package Testcases;

import Constants.CommonVar;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Reports.ReportClass;

public class Basecase extends ReportClass {

    public static WebDriver driver;

    @BeforeTest
    public void initialize() throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver", "/Users/addweb/IdeaProjects/Valeopartners\\ 2/chromedriver");
        ChromeOptions options = new ChromeOptions();
       // options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--headless");
        options.addArguments("window-size=1200,600");
        options.addArguments("--disable-extensions"); // disdemoabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
        driver.get("https://valeodev:F0rD3v0nly!@dev.reports.valeopartners.com/");
//      CommonVar constantVars = new CommonVar();
//      driver.get("https://valeodev:F0rD3v0nly!@dev.reports.valeopartners.com/");
        driver.manage().window().maximize();
        System.out.println("Title of the page is -> " + driver.getTitle());
    }
}