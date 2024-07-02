Feature: Demo Blaze Send Contact Test

  @master
  Scenario: Send Contact Message
    Given user is on the Demo blaze landing page
    And User clicks Contact
    When user input email, name and message
    And user click send message
    Then Thanks for the message!! should be displayed