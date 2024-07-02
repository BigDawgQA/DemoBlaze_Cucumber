Feature: Demo Blaze Login Test

  @master @sanity
  Scenario: Valid Login
    Given user is on the Demo blaze landing page
    And User clicks Log in
    When user input username: "gtestadmin" and password : "test"
    And user click login
    Then user should have access to the product page


  @master
  Scenario: Validate Broken Links
    Given user is on the Demo blaze landing page
    Then validate the page should not have broken links
