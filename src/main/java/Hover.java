import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Hover {

    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html#");
    }

    @Test
    public void hoverTest(){
        WebElement dropdown = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement secondaryMenu = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
        actions.moveToElement(secondaryMenu).perform();
        WebElement secondaryAction = driver.findElement(By.xpath("//a[@onclick='handleSecondaryAction()']"));
        secondaryAction.click();
        WebElement header = driver.findElement(By.xpath("//div[@class='jumbotron secondary-clicked']//h1"));
        assertEquals("Secondary Page", header.getText());


    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
