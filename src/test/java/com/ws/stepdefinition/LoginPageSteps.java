package com.ws.stepdefinition;

import com.ws.base.DriverFactory;
import com.ws.page.HomePage;
import com.ws.page.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginPageSteps {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        DriverFactory.getDriver().get(url);
    }

    @Then("home-page should be displayed")
    public void home_page_should_be_displayed() {
        String title = homePage.getHomePageTitle();
        System.out.println(title);
    }

    @When("I click on login-link")
    public void i_click_on_login_link() {
        homePage.clickLoginLink();
    }

    @Then("login-page should be displayed")
    public void login_page_should_be_displayed() {
        String loginPageTitle = loginPage.getLoginPageTitle();
        System.out.println(loginPageTitle);
    }

    @Then("I enter my email as {string}")
    public void i_enter_my_email_as(String email) {
        loginPage.enterEmail(email);
    }

    @Then("I enter my password as {string}")
    public void i_enter_my_password_as(String password) {
        loginPage.enterPassword(password);
    }

    @Then("I click on login-button")
    public void i_click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("log-out link should be displayed")
    public void log_out_link_should_be_displayed() {
        boolean flag = homePage.isLogoutLinkDisplayed();
        System.out.println("successful login : "+flag);
    }

    @Then("login unsuccessful message should be displayed")
    public void login_unsuccessful_message_should_be_displayed() {
        String errMsg = loginPage.getUnsuccessfulLoginError();
        System.out.println(errMsg);
    }

    @Then("I should see {string} is displayed")
    public void i_should_see_is_displayed(String forgotPasswordLink) {
        boolean flag = loginPage.isForgotPasswordLinkDisplayed();
        System.out.println(flag);
    }

    @Then("element user logged in should be displayed")
    public void element_user_logged_in_should_be_displayed() {
        String expected = "gmail.com";
        String actual = homePage.getUserLoggedIn();
        Assert.assertTrue(actual.equals(expected));
    }
}
