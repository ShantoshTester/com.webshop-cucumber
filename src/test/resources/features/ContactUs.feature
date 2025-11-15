Feature: Contact-Us Feature

  Scenario Outline: Test Contact-Us Form
    Given I navigate to "https://demowebshop.tricentis.com/"
    Then  home-page should be displayed
    When  I click on contact-us link
    Then  contact-us page should be displayed
    When  I fill the contact-us form taking input from "<sheetName>" and "<rowNum>"
    And   I click on submit button
    Then  "Your enquiry has been successfully sent to the store owner." message should be displayed
    Examples:
      | sheetName | rowNum |
      | contactus | 0    |
      | contactus | 1    |
      | contactus | 2    |
      | contactus | 3    |