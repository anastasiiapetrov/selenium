import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cats {

    ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/cats.html");
    }

    @Test
    public void checkHeaderText(){

        WebElement header = driver.findElement(By.className("jumbotron-heading"));
        String expectedText = "Cat memes";
       assertEquals("Header text is not as expected",expectedText, header.getText());

    }
    @Test
    public void timeOfLastCat(){
        WebElement timeValueOfLastCat = driver.findElement(By.xpath("//div[@class='col-sm-4'][6]//small[@class='text-muted']"));
        String expectedTextCats = "9 mins";
        assertEquals(expectedTextCats, timeValueOfLastCat.getText());
    }

    @Test
    public void checkCatsCardsQuantity(){
        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        assertEquals(6,cards.size());
    }
    @Test
    public void nameOfSecondCat(){
        WebElement nameValueOfSecondCat =
                driver.findElement(By.xpath("//div[@class='col-sm-4'][2]//p[@class ='card-text second']"));
        String expectedTextCats = "Serious cat";
        assertEquals(expectedTextCats, nameValueOfSecondCat.getText());
    }
    @Test
    public void buttonOfSecondCat(){
        WebElement buttonOfCat = driver.findElement(By.xpath("//div[@class='col-sm-4'][2]//button[@class ='btn btn-sm btn-outline-secondary'][2]"));
        assertTrue(buttonOfCat.isDisplayed());

    }

        @Test
        public void nameOfAlmubs (){
            WebElement nameOfAlbum = driver.findElement(By.tagName("strong"));
            String expectedNameAlbum = "Cats album";
            assertEquals(expectedNameAlbum, nameOfAlbum.getText());
            assertTrue(nameOfAlbum.isDisplayed());
    }
    @Test
    public void allCardAreDisplayed(){
        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        for (WebElement card:
             cards) {
            assertTrue(card.isDisplayed());
            
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
