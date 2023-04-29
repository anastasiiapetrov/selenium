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

import static junit.framework.TestCase.assertTrue;

public class UploadFile {
    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://suninjuly.github.io/file_input.html");
    }

    @Test
    public void successFillOutForm(){
        WebElement firstName = driver.findElement(By.cssSelector("[name='firstname']"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.cssSelector("[placeholder='Enter last name']"));
        lastName.sendKeys("Black");
        WebElement email = driver.findElement(By.cssSelector("[name='email']"));
        email.sendKeys("johnblack75@gmail.com");
        WebElement uploadFile = driver.findElement(By.id("file"));
        uploadFile.sendKeys("/Users/anastasiiapetrova/Downloads/textfile.txt");
        //uploadFile.sendKeys("/Users/anastasiiapetrova/Downloads/1677255891683387.pdf");
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
