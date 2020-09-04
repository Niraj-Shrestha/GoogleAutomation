package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This class is POM Page Object Model  with PageFactory architecture
public class PageObjects {

    WebDriver driverInherited;

    public PageObjects(WebDriver driver){
        this.driverInherited = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"u_0_b\"]")
    private WebElement loginbutton;

    @FindBy(xpath = "//*[@id=\"u_0_b\"]")
    private WebElement forgetpassword;

    public void setUsername(String Username){
        username.sendKeys(Username);
    }

    public void setPassword(String Password){
        password.sendKeys(Password);
    }

    public void clickLoginButton(){
        loginbutton.click();
    }

    public void clickForgetPassword(){
        forgetpassword.click();
    }
}
