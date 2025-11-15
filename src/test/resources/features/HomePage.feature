Feature: HomePage Components

  Background:
    Given I logged into the application
      | username         | password |
      | admin1@ymail.com | pass@123 |
    Then element user logged in "admin1@ymail.com" should be displayed

  Scenario: Test User Logged-In Successful
    When I click on logout link
    Then home-page should be displayed

  Scenario: Test Product Headers Menu Text
    When I get all the header menu text
      | BOOKS             |
      | COMPUTERS         |
      | ELECTRONICS       |
      | APPAREL & SHOES   |
      | DIGITAL DOWNLOADS |
      | JEWELRY           |
      | GIFT CARDS        |
    Then I verify actual header-text with the expected header-text

  Scenario: Test Product Headers Menu Count
    When I get the header menu count
    Then I should see the total header menu count as 7

