package com.drescoding.offers.model;

import javax.validation.constraints.NotNull;

public class Request {

  @NotNull
  String productName;

  @NotNull
  String currency;

}
