import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Frames {

    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/frames");
    }

    @Test
    public void headerFirstFrame(){
        driver.switchTo().frame("frame1");
        WebElement header1 = driver.findElements(By.id("sampleHeading")).get(0);
        assertTrue(header1.getText().contains("sample"));

        driver.switchTo().defaultContent();  // вернутся назад
        //driver.switchTo().parentFrame(); или можно еще так

        driver.switchTo().frame("frame2");
        WebElement header2 = driver.findElements(By.id("sampleHeading")).get(0);
        assertEquals("This is a sample page", header2.getText());
    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
