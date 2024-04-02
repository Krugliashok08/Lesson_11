package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainPage {
    WEbDriver driver;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[1]/h1")
    private List<WebElement> productTitles;
    @FindBy(xpath = "//*[@id=\"8194f882-84fa-5e43-cf22-b0e340bd9356\"]/div[3]/div[11]/div[1]/div/div/button[1]")
    private WebElement addToBasketButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToBasket(int productIndex) {
        productTitles.get(productIndex).click();
        addToBasketButton.click();
    }
}
