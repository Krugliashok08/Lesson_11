package org.example;

public class Main {
    public static void main(String[] args) {
        MTC mtc = PageFactory.initElements(driver,Wildberries.class);
        driver.get("https://www.wildberries.ru/");
    }
}
