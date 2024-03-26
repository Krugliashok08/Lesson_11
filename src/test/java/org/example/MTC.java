package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.FindBy;
public class TestMTC {
    WEbDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCach().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        @Test
        public void testBlock () {
            driver.get("https://mts.by/");
            WebElement blockTitleElement = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
            Assert.assertEquals("Онлайн пополнение без комиссии", blockTitleElement.getText());
        }
        @Test
        public void testPaymentLogos () {
            driver.get("https://mts.by/");
            Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]"));
        }
        @Test
        public void testReadMoreLink () {
            driver.get("https://mts.by/");
            WebElement readMoreLink = driver.findElement(By.linkText("Подробнее о сервисе"));
            readMoreLink.click();
            Assert.assertTrue(driver.getCurrentUrl().contains("detailed-service-info"));
        }
        @Test
        public void testOnline () {
            driver.get("https://mts.by/");
            WebElement serviceInputField = driver.findElement(By.name("service"));
            WebElement numberInputField = driver.findElement(By.name("number"));
            serviceInputField.sendKeys("Услуги связи");
            numberInputField.sendKeys("297777777");
            WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[2]"));
            continueButton.click();
            Assert.assertTrue(driver.getCurrentUrl().contains("online"));
        }
        @AfterTest
        public void tearDown () {
            driver.close();
            driver.quit();
        }
    }
}
