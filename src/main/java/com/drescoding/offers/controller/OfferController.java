package com.drescoding.offers.controller;

import java.time.LocalDate;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.drescoding.offers.model.Request;
import com.drescoding.offers.model.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

  @RequestMapping(value="", method = POST)
  public static Response offer(@RequestBody Request request) {
    Date date = new Date();
    Response response = new Response("Test description", LocalDate.of( 2014 , 2 , 11 ), true, "EUR", 2.5 );
    return response;
  }
}
