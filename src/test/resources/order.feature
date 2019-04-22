Feature: Are my orders correct?

  Scenario: An order with all its information is added to the database
    Given The merchant adds a product to the database
    When The customer asks for an offer on the product
    Then It should give them the full details
