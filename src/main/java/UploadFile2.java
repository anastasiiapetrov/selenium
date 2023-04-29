import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class UploadFile2 {

    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/upload-download");
    }

@Test
    public void uploadCheckSuccess(){
        WebElement chooseFileButton = driver.findElement(By.id("uploadFile"));
        chooseFileButton.sendKeys("/Users/anastasiiapetrova/Downloads/dog.png");
        WebElement fileName = driver.findElement(By.id("uploadedFilePath"));
        assertTrue(fileName.getText().contains("dog"));
    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
