
Feature: Login Feature
  Scenario: Login With valid details
    Given navigate to "https://nobroker.in"
    And click on login
    When Enter mobile no "9172926596"
    And click on i have password
    And Enter password as "aksh1050"
    Then click on continue
    And close the driver
