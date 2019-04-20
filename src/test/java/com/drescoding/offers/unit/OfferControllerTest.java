package com.drescoding.offers.unit;

import java.time.LocalDate;

import com.drescoding.offers.controller.OfferController;
import com.drescoding.offers.model.Request;
import com.drescoding.offers.model.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OfferControllerTest {

  @Test
  public void returnsResponse(){
    //Given
    Request request = new Request("Dress", "EUR");

    //When
    Response response = OfferController.offer(request);

    //Then
    assertEquals("EUR", response.getCurrency());
    assertEquals(true, response.getValid());
    assertEquals("2.5", response.getPrice().toString());
    assertEquals("Test description", response.getDescription());
    assertEquals(LocalDate.of( 2014 , 2 , 11 ), response.getExpiryDate());
  }
}
