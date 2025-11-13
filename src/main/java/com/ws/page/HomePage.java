package com.ws.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ******************************************** Page Locators ********************************************* //

    private By login_link = By.linkText("Log in");
    private By logout_link = By.linkText("Log out");
    private By user_email = By.xpath("(//a[@class='account'])[1]");

    // ******************************************** Page Methods ********************************************** //

    public String getUserLoggedIn() {
        return driver.findElement(user_email).getText();
    }

    public boolean isLogoutLinkDisplayed() {
        return driver.findElement(logout_link).isDisplayed();
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public void clickLoginLink() {
        driver.findElement(login_link).click();
    }
}
