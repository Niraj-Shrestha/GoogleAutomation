package Base;

import Utils.TimeStamp;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class BaseTest {
    public WebDriver driver;
    public ExtentTest logger;
    public ExtentReports report;
    public String URL;
    public String Browser;
    public String Machine;


    @BeforeSuite
    public void setupConfigFile() throws IOException {
        InputStream File  = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
        Properties props = new Properties();
        props.load(File);
        URL = props.getProperty("URL");
        Browser = props.getProperty("Browser");
        Machine = props.getProperty("Machine");
    }

    @BeforeTest
    public void setupExtentReport(){
        TimeStamp time = new TimeStamp();
        report = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/Report_" + time.timeStamp() + ".html");
        report.addSystemInfo("username","ashmita").addSystemInfo("enviroment","QA");
    }

    @BeforeTest
    public void setupBrowser(){
        /*System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        //driver.get("https://www.facebook.com/");
        driver.get(URL);*/
        /*if(Browser == "Chrome"){
            System.setProperty("webdriver.chrome.driver","chromedriver");
            driver = new ChromeDriver();
        }
        else if(Browser == "Firefox"){
            System.setProperty("wwebdriver.gecko.driver","geckodriver");
            driver = new FirefoxDriver();
        }*/
        if(Machine.contentEquals("Mac")) {
            switch (Browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "Drivers/mac/chromedriver");
                    driver = new ChromeDriver();
                    break;

                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", "Drivers/mac/geckodriver");
                    driver = new FirefoxDriver();
                    break;

                default:
                    System.out.println("Driver not found");
            }
        }else if(Machine.contentEquals("windows")){
            switch (Browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "Drivers/windows/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;

                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", "Drivers/windows/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;

                default:
                    System.out.println("Driver not found");
            }
        }
        else {
            System.out.println("no drivers available for windows");
        }

        driver.get(URL);
    }

    @AfterTest
    public void close(){
        logger = report.startTest("Exit Driver");
        driver.close();
        logger.log(LogStatus.PASS,"Driver Exited");
        report.flush();
    }
}


