import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FBLoginAutomation {

    WebDriver driver;

    @BeforeTest
    public void setupBrowser(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        //driver.get("https://www.facebook.com/");
        driver.get("https://www.google.com/");
    }

    /*@Test
    public void loginToFacebook(){
        PageObjects login = new PageObjects(driver);
        login.setUsername("Test@gmail.com");
        login.setPassword("Password@123");
        login.clickLoginButton();
    }*/

    @Test
    public void SearchInGoogle(){
       GoogleSearch find = new GoogleSearch(driver);

       String ExpectedTitle = "Google111";
       String ActualTitle = driver.getTitle();

       /*if(ExpectedTitle.contentEquals(ActualTitle))
       {
           System.out.println("Test Passed");
           System.out.println("ExpectedTitle is "+ ExpectedTitle + " and Actual Title is " + ActualTitle);
       }
       else {
           System.out.println("Test Failed");
           System.out.println("ExpectedTitle is "+ ExpectedTitle + " and Actual Title is " + ActualTitle);
       }*/

        Assert.assertEquals(ActualTitle,ExpectedTitle);

       if(find.startTest() == true) {
           find.setSearchbar("selenium maven dependency");
           find.clickSearchButton();
       }
       else {
           System.out.println("could not locate element");
       }

    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
