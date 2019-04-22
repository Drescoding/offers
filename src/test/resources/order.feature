Feature: Are my orders correct?

  Scenario: An order with all its information is added to the database
    Given The merchant provides information on a product to add to the database
    When The product is added to the database
    Then It should add it to the database


  Scenario: Some mandatory fields are left blanks
    Given The merchant adds a product to the database with missing fields
    When The product is added to the database
    Then It should return an error
