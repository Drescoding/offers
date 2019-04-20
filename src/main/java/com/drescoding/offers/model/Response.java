package com.drescoding.offers.model;

import java.util.Date;
import javax.validation.constraints.NotNull;

public class Response {

  @NotNull
  String description;

  @NotNull
  Date expiryDate;

  @NotNull
  Boolean valid;

  @NotNull
  String currency;

  @NotNull
  Double price;

}
