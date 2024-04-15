package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class WildberriesTest {
    WebDriver driver;
    MainPage mainPage;
    BasketPage basketPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        basketPage = new BasketPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.wildberries.ru/");
    }

    @Test
    public void testAddToBasket() {
        mainPage.addToBasket(0);
        mainPage.addToBasket(1);
        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }
}
