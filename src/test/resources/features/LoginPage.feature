Feature: Login Page Feature

  Scenario: Login Page Title Verification Scenario
    Given I navigate to "https://demowebshop.tricentis.com/"
    Then  home-page should be displayed
    When  I click on login-link
    Then  login-page should be displayed

  Scenario: Test Valid Login Scenario
    Given I navigate to "https://demowebshop.tricentis.com/"
    Then  home-page should be displayed
    When  I click on login-link
    Then  login-page should be displayed
    Then  I enter my email as "admin1@ymail.com"
    And   I enter my password as "pass@123"
    And   I click on login-button
    And   log-out link should be displayed

  Scenario: Test Invalid Login Scenario
    Given I navigate to "https://demowebshop.tricentis.com/"
    Then  home-page should be displayed
    When  I click on login-link
    Then  login-page should be displayed
    Then  I enter my email as "admin1@ymail.com"
    And   I enter my password as "wrongpassword"
    And   I click on login-button
    And   login unsuccessful message should be displayed

  Scenario: Test Forgot Password Link isDisplayed
    Given I navigate to "https://demowebshop.tricentis.com/"
    Then  home-page should be displayed
    When  I click on login-link
    Then  I should see "forgot password link" is displayed

  Scenario: Test Failure Login Scenario
    Given I navigate to "https://demowebshop.tricentis.com/"
    Then  home-page should be displayed
    When  I click on login-link
    Then  login-page should be displayed
    Then  I enter my email as "admin1@ymail.com"
    And   I enter my password as "pass@123"
    And   I click on login-button
    Then  element user logged in should be displayed





