package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    public String screenshots(WebDriver driver) throws IOException {
        TimeStamp time = new TimeStamp();
        File source =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File location = new File(System.getProperty("user.dir") + "/Screenshots/SS_" + time.timeStamp() + ".png" );
        String destination = location.getAbsolutePath();
        FileUtils.copyFile(source,location);
        return destination;
    }
}
