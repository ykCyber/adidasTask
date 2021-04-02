
@purchasing
Feature: purchasing product

  Scenario: Customer can purchase
    Given the customer is on the homePage
    When the customer  clicks on Laptops
    And the customer  clicks on "Sony vaio i5"


    And the customer  clicks on Add to cart
    And the customer  Accept pop up confirmation
    And the customer clicks Home button to return to the HomePage
    And the customer  clicks on Laptops
    And the customer  clicks on "Dell i7 8gb"
    And the customer  clicks on Add to cart
    And the customer  Accept pop up confirmation
    And the customer  clicks to Cart module
    And the customer  deletes Dell i7 8gb from Cart
    And the customer  clicks on Place order button
    And the customer  fills in all web form fields and click Purchase
    And the customer  captures and logs purchase Id and Amount
    Then purchase amount equals expected
    And the customer  clicks on Ok


