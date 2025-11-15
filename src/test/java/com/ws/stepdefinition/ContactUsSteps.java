package com.ws.stepdefinition;

import com.ws.base.DriverFactory;
import com.ws.page.ContactUsPage;
import com.ws.page.HomePage;
import com.ws.utils.Constants;
import com.ws.utils.ExcelUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactUsSteps {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @When("I click on contact-us link")
    public void i_click_on_contact_us_link() {
        homePage.clickContactUsLink();
    }

    @Then("contact-us page should be displayed")
    public void contact_us_page_should_be_displayed() {
        String contactUsPageTitle = contactUsPage.getContactUsPageTitle();
        System.out.println(contactUsPageTitle);
        Assert.assertTrue(contactUsPageTitle.contains("Contact"));
    }

    @When("I fill the contact-us form taking input from {string} and {string}")
    public void i_fill_the_contact_us_form_taking_input_from_and(String sheetName, String rowNum) throws Exception {
       ExcelUtil excelUtil = new ExcelUtil();
        List<Map<String, String>> data = excelUtil.getData(Constants.excelFilePath, "contactus");
        String name = data.get(Integer.parseInt(rowNum)).get("Your name");
       String email = data.get(Integer.parseInt(rowNum)).get("Your email");
       String enquiry = data.get(Integer.parseInt(rowNum)).get("Enquiry");
       contactUsPage.enterContactUsDetails(name, email, enquiry);
    }

    @When("I click on submit button")
    public void i_click_on_submit_button() {
        contactUsPage.clickSubmitButton();
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
