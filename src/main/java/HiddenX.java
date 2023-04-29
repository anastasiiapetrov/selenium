import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;


public class HiddenX {
    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/get_attribute.html");
    }


    public double fundCalc(double x){
        return log(abs(12*sin(x)));
    }


    @Test
    public void validAnswer() throws InterruptedException {
        WebElement treasure = driver.findElement(By.id("treasure"));
        double xValue = parseDouble(treasure.getAttribute("valuex")); // String to double
        WebElement answerInputField = driver.findElement(By.id("answer"));
        String newValue = String.valueOf(fundCalc(xValue)); // double to String
        answerInputField.sendKeys(newValue);

        WebElement robotCheckbox = driver.findElement(By.id("robotCheckbox"));
        robotCheckbox.click();
        WebElement robotsRule = driver.findElement(By.id("robotsRule"));
        robotsRule.click();

        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        sleep(10000);


    }
}

