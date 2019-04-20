package com.drescoding.offers.unit;

import com.drescoding.offers.controller.OfferController;
import com.drescoding.offers.model.Request;
import com.drescoding.offers.model.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OfferControllerTest {

  @Test
  public void returnsThePriceInTheCorrectCurrency(){
    //Given
    Request request = new Request("Dress", "EUR");

    //When
    Response response = OfferController.offer(request);

    //Then
    assertEquals("EUR", response.getCurrency());
  }
}
