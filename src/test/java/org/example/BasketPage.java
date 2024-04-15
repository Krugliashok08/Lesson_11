package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class BasketPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/a/span[1]")
    private List<WebElement> productTitles;
    @FindBy (xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/input")
    private List<WebElement> productQuantities;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[2]")
    private List<WebElement> productPrices;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/form/div[2]/div/div/div/div[3]/p/span[2]/span")
    private WebElement totalPrice;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
