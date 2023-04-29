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

public class NestedFrames {

    ChromeDriver driver;

    @Before
    public void setUp(){


        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/nestedframes");
    }

    @Test
    public void textFrame(){
        driver.switchTo().frame("frame1");
        WebElement text1 = driver.findElement(By.tagName("body"));
        System.out.println(text1.getText());
        assertTrue(text1.getText().contains("Parent frame"));
        WebElement frame2 = driver.findElement(By.cssSelector("[srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(frame2);
        WebElement text2 = driver.findElement(By.tagName("p"));
        assertTrue(text2.getText().contains("Child Iframe"));


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}


