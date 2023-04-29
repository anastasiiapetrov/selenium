import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class Registration {
    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://suninjuly.github.io/registration1.html");
}
    @Test
    public void header(){
    WebElement nameOfHeader = driver.findElement(By.tagName("h1"));
    String expectedText= "Registration";
    assertEquals(expectedText, nameOfHeader.getText());
}
    @Test
    public void inputAllFields() throws InterruptedException {
        WebElement inputFirstName = driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
        WebElement inputLastName = driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
        WebElement inputEmail = driver.findElement(By.xpath("//input[@placeholder='Input your email']"));
        WebElement inputPhone = driver.findElement(By.xpath("//input[@placeholder='Input your phone:']"));
        WebElement inputAddress = driver.findElement(By.xpath("//input[@placeholder='Input your address:']"));
        WebElement submitButton = driver.findElement(By.tagName("button"));

        inputFirstName.sendKeys("John");
        inputLastName.sendKeys("Johnson");
        inputEmail.sendKeys("john93@gmail.com");
        inputPhone.sendKeys("+48294829184");
        inputAddress.sendKeys("Berlin, Kreuzberg Platz 74");
        submitButton.click();
        
        WebElement nameOfHeader = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", nameOfHeader.getText());
    }


    @Test
    public void invalidEmailValue(){
        WebElement inputFirstName = driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
        WebElement inputLastName = driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
        WebElement submitButton = driver.findElement(By.tagName("button"));

        inputFirstName.sendKeys("");
        inputLastName.sendKeys("Johnson");
        submitButton.click();

        //WebElement nameOfHeader = driver.findElement(By.tagName("h1"));
      // assertNotEquals("Congratulations! You have successfully registered!", nameOfHeader.getText());

        assertEquals("Please fill in this field.", inputFirstName.getAttribute("validationMessage"));

    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
