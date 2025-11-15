package com.ws.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // ******************************************** Page Locators ********************************************* //

    private By yourNameTextBox = By.id("FullName");
    private By yourEmailTextBox = By.name("Email");
    private By enquiryTextArea = By.id("Enquiry");
    private By submitButton  = By.name("send-email");
    private By successMessage = By.xpath("//div[@class='result']");

    // ******************************************** Page Methods ********************************************** //

    public String getContactUsPageTitle() {
        return driver.getTitle();
    }

    public void enterContactUsDetails(String name, String email, String enquiry) {
        driver.findElement(yourNameTextBox).sendKeys(name);
        driver.findElement(yourEmailTextBox).sendKeys(email);
        driver.findElement(enquiryTextArea).sendKeys(enquiry);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
