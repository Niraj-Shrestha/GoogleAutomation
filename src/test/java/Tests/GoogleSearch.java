package Tests;

import Base.BaseTest;
import Utils.ScreenShots;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleSearch extends BaseTest {

    @Test
    public void SearchInGoogle() throws IOException {
        PageObjects.GoogleSearch find = new PageObjects.GoogleSearch(driver);
        ScreenShots ss = new ScreenShots();
        logger = report.startTest("starting google search test") ;
        String ExpectedTitle = "Google";
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
}
