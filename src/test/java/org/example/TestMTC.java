package org.example;
mport io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMTC {
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }
    @Test()
    public void testBlock() {
        WebDriver driver = null;
        driver.get("https://www.mts.by/");
        WebElement mobileLink = driver.findElement(By.linkText("Онлайн пополнение без комиссии"));
        mobileLink.click();
        WebElement phoneNumber = driver.findElement(By.id("connetion-phone"));
        String phoneNumberPlaceholder = phoneNumber.getAttribute("placeholder");
        Assert.assertEquals(phoneNumberPlaceholder, "Номер абонента");
        WebElement amountField = driver.findElement(By.id("internet-phone"));
        String amountPlaceholder = amountField.getAttribute("placeholder");
        Assert.assertEquals(amountPlaceholder, "Сумма");
        WebElement emailField = driver.findElement(By.id("internet-email"));
        String emailPlaceholder = emailField.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholder, "Email");

        phoneNumber.sendKeys("297777777");
        amountField.sendKeys("10");
        emailField.sendKeys("testng@example.com");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[2]"));
        continueButton.click();

        WebElement visaIcon = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[1]/section/div/div[2]/ul/li[1]/img"));
        WebElement mastercardIcon = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[1]/section/div/div[2]/ul/li[3]/img"));
        WebElement belcartIcon = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[1]/section/div/div[2]/ul/li[5]/img"));
        WebElement mirIcon = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[1]/section/div/div[2]/ul/li[6]/img"));

        Assert.assertTrue(visaIcon.isDisplayed());
        Assert.assertTrue(mastercardIcon.isDisplayed());
        Assert.assertTrue(belcartIcon.isDisplayed());
        Assert.assertTrue(mirIcon.isDisplayed());
        }
    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
