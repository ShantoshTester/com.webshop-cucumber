package com.ws.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ******************************************** Page Locators ********************************************* //

    private By login_link = By.linkText("Log in");
    private By logout_link = By.linkText("Log out");
    private By user_email = By.xpath("(//a[@class='account'])[1]");
    private By headerMenu = By.xpath("//ul[@class='top-menu']/li/a");
    private By contactUsLink = By.linkText("Contact us");

    // ******************************************** Page Methods ********************************************** //

    public void clickContactUsLink() {
        driver.findElement(contactUsLink).click();
    }

    public int getHeaderMenuCount() {
       return driver.findElements(headerMenu).size();
    }

    public ArrayList<String> getHeaderMenuText() {
        ArrayList<String> headers = new ArrayList<>();
        List<WebElement> menu = driver.findElements(headerMenu);
        for(WebElement menuItem : menu) {
            String headerText = menuItem.getText().trim();
            headers.add(headerText);
        }
        return headers;
    }

    public void clickLogout() {
        driver.findElement(logout_link).click();
    }

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
