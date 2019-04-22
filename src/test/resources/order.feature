Feature: Are my orders correct?

  Scenario: An order with all its information is added to the database
    Given The merchant provides information on a product to add to the database
    When The product is added to the database
    Then It should add it to the database


  Scenario: Some mandatory fields are left blanks
    Given The merchant adds a product to the database with missing fields
    When The product is added to the database
    Then It should return an error

  Scenario: The order expires
    Given The merchant provides information on a expired product
    When The product is added to the database
    And The customer asks for an offer
    Then The order is cancelled

  Scenario: The merchant wants to cancel an existing offer before expiry date
    Given The merchant provides information on a product to add to the database
    When The product is added to the database
    And The merchant cancels it
    And The customer asks for an offer
    Then It should return an error


