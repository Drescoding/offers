package com.drescoding.offers.steps;

import java.util.ArrayList;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.Assert;

@Slf4j
public class OrderSteps {

  String requestOrder;
  String responseString;
  Response response;
  String idProduct;

  @Given("^The merchant provides information on a product to add to the database$")
  public void The_merchant_provides_information_on_a_product_to_add_to_the_database() {
    requestOrder = "{\n" +
        "\t\"name\": \"dress\",\n" +
        "\t\"currency\": \"EUR\",\n" +
        "\t\"price\": 20,\n" +
        "\t\"description\": \"Brand new red dress\",\n" +
        "\t\"expiryDate\": \"11/09/2021\",\n" +
        "\t\"valid\": true\n" +
        "}";
  }

  @Given("^The merchant provides information on a expired product$")
  public void The_merchant_provides_information_on_a_expired_product() {
    requestOrder = "{\n" +
        "\t\"name\": \"dress\",\n" +
        "\t\"currency\": \"EUR\",\n" +
        "\t\"price\": 20,\n" +
        "\t\"description\": \"Brand new red dress\",\n" +
        "\t\"expiryDate\": \"11/09/2017\",\n" +
        "\t\"valid\": true\n" +
        "}";
  }

  @Given("^The merchant adds a product to the database with missing fields$")
  public void The_merchant_adds_a_product_to_the_database_with_missing_fields() {
    requestOrder = "{\n" +
        "\t\"id\": 1,\n" +
        "\t\"currency\": \"EUR\",\n" +
        "\t\"price\": 20,\n" +
        "\t\"description\": \"Brand new red dress\",\n" +
        "\t\"valid\": true\n" +
        "}";
  }


  @When("^The product is added to the database$")
  public void the_product_is_added_to_the_database() {
    RestAssured.baseURI = "http://localhost:8080";
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(requestOrder);
    response = httpRequest.post("/addProduct");
    log.debug("Response: " + response.asString());
    idProduct = response.asString();
    log.debug("The ID for added product is: " + idProduct);

  }


  @And("^The customer asks for an offer$")
  public void the_customer_ask_for_an_offer() {
    RestAssured.baseURI = "http://localhost:8080";
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(requestOrder);
    response = httpRequest.get("/product/" + idProduct);
    log.debug("Customer response: " + response.asString());
  }

  @When("^The merchant cancels it$")
  public void the_merchant_cancels_it() {
    RestAssured.baseURI = "http://localhost:8080";
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(requestOrder);
    response = httpRequest.delete("/product/" + idProduct);
    log.debug("Deleted product" + response.asString());
  }



  @Then("^It should add it to the database$")
  public void it_should_add_it_to_the_database() {
    Assert.assertEquals(idProduct, response.asString());
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Then("^It should return an error$")
  public void it_should_return_an_error() {
    log.debug("Error Response: " + response.asString());
    Assert.assertNotEquals(200, response.getStatusCode());
  }


  @Then("^The order is cancelled$")
  public void the_order_is_cancelled() {
    log.debug("Cancelled order response: " + response.asString());
   Assert.assertEquals(false, response.jsonPath().get("valid"));
  }

}
