import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.sum;
import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;

public class DropDown {


    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/selects2.html");
    }
@Test
    public void correctSum() throws InterruptedException {
        WebElement num1 =driver.findElement(By.id("num1"));
        WebElement num2 =driver.findElement(By.id("num2"));
        int value1 = parseInt(num1.getText());
        int value2 = parseInt(num2.getText());
        int result = sum(value1, value2);
        System.out.println(result);

        WebElement dropDown = driver.findElement(By.id("dropdown"));
        dropDown.click();
        String newValue = String.valueOf(result);
        WebElement answer = driver.findElement(By.cssSelector("[value='"+newValue+"']"));
        answer.click();
         WebElement submitButton = driver.findElement(By.tagName("button"));
         submitButton.click();


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


    }




    @After
    public void tearDown(){
        driver.quit();
    }
}
