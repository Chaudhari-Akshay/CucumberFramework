
Feature: Signup Feature
  Scenario: Signup With valid details
    Given navigate to https://nobroker.in website
    And click on signup
    When Enter mobile no 
    And Enter name and email
    Then click on continue button
    And close the webdriver
