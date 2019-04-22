package com.drescoding.offers.steps;

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

  @When("^The merchant adds a product to the database$")
  public void The_merchant_adds_a_product_to_the_database() throws JSONException {
    RestAssured.baseURI = "http://localhost:8080";
    requestOrder = "{\n" +
        "\t\"id\": 1,\n" +
        "\t\"name\": \"dress\",\n" +
        "\t\"currency\": \"EUR\",\n" +
        "\t\"price\": 20,\n" +
        "\t\"description\": \"Brand new red dress\",\n" +
        "\t\"expiryDate\": \"11/20/2019\",\n" +
        "\t\"valid\": true\n" +
        "}";
  }


  @When("^The customer asks for an offer on the product$")
  public void the_customer_asks_for_an_offer_on_the_product() {
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(requestOrder);
    Response response = httpRequest.post("/addProduct");
    responseString = response.asString();

  }

  @Then("^It should give them the full details$")

  public void it_should_give_them_the_full_details() {
    Assert.assertEquals("1", responseString);
  }
}
