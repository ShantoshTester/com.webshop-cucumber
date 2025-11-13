package com.ws.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ******************************************** Page Locators ********************************************* //

    private By emailTextbox = By.id("Email");
    private By passwordTextbox = By.name("Password");
    private By loginButton = By.xpath("//input[@value='Log in']");
    private By forgotPasswordLink = By.linkText("Forgot password?");
    private By invalidCredentialsErr = By.xpath("//span[contains(text(),'unsuccessful')]");

    // ******************************************** Page Methods ********************************************** //

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void enterEmail(String email) {
        driver.findElement(emailTextbox).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextbox).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public String getUnsuccessfulLoginError() {
        return driver.findElement(invalidCredentialsErr).getText();
    }
}
