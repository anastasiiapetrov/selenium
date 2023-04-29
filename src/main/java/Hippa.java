import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Hippa {
    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.insidetracker.com/");
}

    @Test
    public void checkHeaderText() throws InterruptedException {

        WebElement hippaButton = driver.findElement(By.id("HIPAA"));
        hippaButton.click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));

        WebElement headerHippa = driver.findElement(By.id("hs_cos_wrapper_name"));
        assertTrue(headerHippa.getText().contains("HIPAA"));
        assertTrue(driver.getCurrentUrl().contains("hipaa-compliant"));




    }





    @After
    public void tearDown(){
        driver.quit();
    }


}
