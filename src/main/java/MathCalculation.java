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
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;

public class MathCalculation {
    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://suninjuly.github.io/math.html");
}


    public double fundCalc(double x){
        return log(abs(12*sin(x)));
    }


    @Test
    public void validAnswer() throws InterruptedException {
        WebElement x = driver.findElement(By.id("input_value"));
        double xValue = parseDouble(x.getText()); // String to double
        System.out.println(xValue);
        System.out.println(fundCalc(xValue));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }





    @After
    public void tearDown(){
        driver.quit();
    }

}
