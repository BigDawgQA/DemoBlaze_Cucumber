Feature: Demo Blaze Sign-Up Test

  @master @sanity
  Scenario: Valid Sign Up
    Given user is on the Demo blaze landing page
    And User clicks Sign up
    When user provides username: "<username>" and password : "<password>"
    And user click Sign up
    Then alert is displayed with Sign up successful.

  @master
  Scenario: Invalid Sign Up
    Given user is on the Demo blaze landing page
    And User clicks Sign up
    When user provides already used username: "<username>" and password : "<password>"
    And user click Sign up
    Then alert is displayed and sign up is not successful.