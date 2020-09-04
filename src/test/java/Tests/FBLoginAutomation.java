package Tests;

import PageObjects.GoogleSearch;
import Utils.ScreenShots;
import Utils.TimeStamp;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Time;

public class FBLoginAutomation {

    WebDriver driver;
    ExtentTest logger;
    ExtentReports report;

    @BeforeTest
    public void setupExtentReport(){
        TimeStamp time = new TimeStamp();
        report = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/Report_" + time.timeStamp() + ".html");
        report.addSystemInfo("username","ashmita").addSystemInfo("enviroment","QA");
    }

    @BeforeTest
    public void setupBrowser(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        //driver.get("https://www.facebook.com/");
        driver.get("https://www.google.com/");
    }

    /*@Test
    public void loginToFacebook(){
        PageObjects.PageObjects login = new PageObjects.PageObjects(driver);
        login.setUsername("Test@gmail.com");
        login.setPassword("Password@123");
        login.clickLoginButton();
    }*/

    @Test
    public void SearchInGoogle() throws IOException {
       GoogleSearch find = new GoogleSearch(driver);
       ScreenShots ss = new ScreenShots();
       logger = report.startTest("starting google search test") ;
       String ExpectedTitle = "Google234";
       String ActualTitle = driver.getTitle();

       if(ExpectedTitle.contentEquals(ActualTitle))
       {
           System.out.println("Test Passed");
           System.out.println("ExpectedTitle is "+ ExpectedTitle + " and Actual Title is " + ActualTitle);
           logger.log(LogStatus.PASS,"ExpectedTitle is "+ ExpectedTitle + " and Actual Title is " + ActualTitle);
       }
       else {
           System.out.println("Test Failed");
           System.out.println("ExpectedTitle is "+ ExpectedTitle + " and Actual Title is " + ActualTitle);
           logger.log(LogStatus.FAIL,"ExpectedTitle is "+ ExpectedTitle + " and Actual Title is " + ActualTitle);
           logger.log(LogStatus.FAIL,logger.addScreenCapture(ss.screenshots(driver)));
       }

        //Assert.assertEquals(ActualTitle,ExpectedTitle);

       if(find.startTest() == true) {
           find.setSearchbar("selenium maven dependency");
           logger.log(LogStatus.PASS,"Entered search parameter in search field");
           find.clickSearchButton();
           logger.log(LogStatus.PASS,"Clicked on Search button");
       }
       else {
           System.out.println("could not locate element");
       }

    }

    @AfterTest
    public void close(){
        logger = report.startTest("Exit Driver");
        driver.close();
        logger.log(LogStatus.PASS,"Driver Exited");
        report.flush();
    }
}
