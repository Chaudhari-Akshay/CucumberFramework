
Feature: Play Video on Website

  Scenario: Playing youtube video on website
    Given go to https://nobroker.in
    When scroll down towords video
    Then play the video
    And wait for 5 sec close the browser
   