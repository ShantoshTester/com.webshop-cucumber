package com.ws.stepdefinition;

import com.ws.base.DriverFactory;
import com.ws.page.HomePage;
import com.ws.page.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HomePageSteps {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    long actualHeaderMenuCount;
    List<String> actual;
    ArrayList<String> expected;

    @Given("I logged into the application")
    public void i_logged_into_the_application(DataTable dataTable) {
        DriverFactory.getDriver().get("https://demowebshop.tricentis.com/");
        homePage.clickLoginLink();
        List<Map<String, String>> credientials = dataTable.asMaps(String.class, String.class);
        String un = credientials.get(0).get("username");
        String pwd = credientials.get(0).get("password");
        loginPage.doLogin(un, pwd);
    }

    @Then("element user logged in {string} should be displayed")
    public void element_user_logged_in_should_be_displayed(String expected) {
        String actual = homePage.getUserLoggedIn();
        System.out.println("actual: " + actual+" "+expected);
        Assert.assertEquals(actual, expected);
    }

    @When("I click on logout link")
    public void i_click_on_logout_link() {
        homePage.clickLogout();
    }

    @When("I get all the header menu text")
    public void i_get_all_the_header_menu_text(DataTable dataTable) {
        actual = dataTable.asList(String.class);
        expected = homePage.getHeaderMenuText();
        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);
    }

    @Then("I verify actual header-text with the expected header-text")
    public void i_verify_actual_header_text_with_the_expected_header_text() {
        Assert.assertEquals(actual, expected);
        System.out.println("actual header menu is matching with the expected header-text");
    }

    @When("I get the header menu count")
    public void i_get_the_header_menu_count() {
        actualHeaderMenuCount = homePage.getHeaderMenuCount();
        System.out.println(actualHeaderMenuCount);

    }

    @Then("I should see the total header menu count as {int}")
    public void i_should_see_the_total_header_menu_count_as(Integer expectedHeaderMenuCount) {
        System.out.println(expectedHeaderMenuCount+" :: "+actualHeaderMenuCount);
        Assert.assertTrue(expectedHeaderMenuCount == actualHeaderMenuCount);
    }
}
