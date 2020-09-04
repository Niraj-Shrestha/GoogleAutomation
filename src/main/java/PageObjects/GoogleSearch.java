package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
    WebDriver driverInherited;

    public GoogleSearch(WebDriver driver){
        this.driverInherited = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchbar;

    @FindBy (xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")
    private WebElement searchbutton;

    public void setSearchbar(String SearchText){
        searchbar.sendKeys(SearchText);
    }

    public void clickSearchButton(){
        searchbutton.click();
    }

    public boolean startTest(){
        if (searchbar.isDisplayed()){
            return true;
        }
        else return false;
    }
}
