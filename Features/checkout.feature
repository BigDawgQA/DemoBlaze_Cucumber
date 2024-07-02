Feature: Demo Blaze Checkout Test

  @master @sanity
  Scenario: Valid Checkout
    Given user is on the Demo blaze landing page
    And User clicks Log in
    And user input username: "gtestadmin" and password : "test"
    And user click login
    And user should have access to the product page
    When user adds products to cart
    And user proceed to checkout with details below:
      | customerName  | testuser   |
      | country       | USA        |
      | city          | NewYork    |
      | creditCard    | 1234567890 |
      | month         | June       |
      | year          | 2024       |
    Then checkout should be successful


  @master
  Scenario: Checkout Without Login
    Given user is on the Demo blaze landing page
    When user adds products to cart
    And user proceed to checkout with details below:
      | customerName  | testuser   |
      | country       | USA        |
      | city          | NewYork    |
      | creditCard    | 1234567890 |
      | month         | June       |
      | year          | 2024       |
    Then checkout should be successful

