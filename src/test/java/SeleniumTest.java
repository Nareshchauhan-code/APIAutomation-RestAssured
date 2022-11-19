import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class SeleniumTest {

    @Test
    public void checkSeleniumVersion() throws IOException {

      //  WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile = new File("D:\\!!Naresh\\Important Documents\\Naresh Chauhan doc\\Cyient Offer Letter\\Naresh.png");

        FileUtils.copyFile(SrcFile, DestFile);

        driver.quit();

    }
}
