package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebElement;
public class TestMTC {
    public static void main(String[] args) {
    WEbDriver driver;
    WebDriverManager.chromedriver().clearDriverCach().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.mts.by/");

    String[] paymentOptions = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
    for (String option : paymentOptions) {
        WebElement paymentOption = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[1]/section/div/div[1]/div[1]"));
        paymentOption.click();
        WebElement phoneNumberField = driver.findElement(By.id("phone_number"));
        System.out.println("Text in phone number field for " + option + ": " + phoneNumberField.getAttribute("placeholder"));
        driver.navigate().refresh();
    }
        WebElement servicesPaymentOption = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[1]/section/div/div[1]/div[1]/div[2]"));
        servicesPaymentOption.click();
        WebElement phoneNumberInput = driver.findElement(By.id("phone_number"));
        phoneNumberInput.sendKeys("297777777");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\\\"pay-section\\\"]/div/div/div[2]/section/div/div[1]/div[2]"));
        continueButton.click();
        WebElement paymentAmountButton = driver.findElement(By.className("SumField"));
        System.out.println("Payment amount on the button: " + paymentAmountButton.getText());
        WebElement phoneNumberSummary = driver.findElement(By.id("phone_number"));
        System.out.println("Phone number summary: " + phoneNumberSummary.getAttribute("value"));
        WebElement cardNumberField = driver.findElement(By.id("card_number"));
        System.out.println("Text in card number field: " + cardNumberField.getAttribute("placeholder"));
        WebElement visaIcon = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[1]/section/div/div[2]/ul/li[1]"));
        System.out.println("Visa icon is displayed: " + visaIcon.isDisplayed());
        WebElement mastercardIcon = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[1]/section/div/div[2]/ul/li[4]"));
        System.out.println("MasterCard icon is displayed: " + mastercardIcon.isDisplayed());
        driver.quit();
        }
    }
