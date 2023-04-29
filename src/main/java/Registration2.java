import org.junit.After;
import org.junit.Assert;
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

import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Registration2<WebDeiverWait> {

    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/simple_form_find_task.html");

}
@Test
public void Test() throws InterruptedException {
    WebElement inputFirstName = driver.findElement(By.cssSelector("[name='first_name']"));
    WebElement inputLastName = driver.findElement(By.cssSelector("[name='last_name']"));
    WebElement inputCity = driver.findElement(By.cssSelector("[class*='city']"));
    WebElement inputCountry = driver.findElement(By.id("country"));



    inputFirstName.sendKeys("Mark");
    inputLastName.sendKeys("Johnson");
    inputCity.sendKeys("Paris");
    inputCountry.sendKeys("France");
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


    @Test
    public void IvalidTest() throws InterruptedException {
        WebElement inputFirstName = driver.findElement(By.cssSelector("[name='first_name']"));
        WebElement inputLastName = driver.findElement(By.cssSelector("[name='last_name']"));
        WebElement inputCity = driver.findElement(By.cssSelector("[class*='city']"));
        WebElement inputCountry = driver.findElement(By.id("country"));
        inputFirstName.sendKeys("Mark");
        inputLastName.sendKeys("Johnson");
        inputCity.sendKeys("Paris");

        WebElement submitButton = driver.findElement(By.tagName("button"));
        sleep(10000);
       // assertEquals("disabled", submitButton.getAttribute("disabled"));
    }



}