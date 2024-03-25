package org.example;

public class Main {
    public static void main(String[] args) {
        MTC mtc = PageFactory.initElements(driver,MTC.class);
        driver.get("https://www.mts.by/");
    }
}
