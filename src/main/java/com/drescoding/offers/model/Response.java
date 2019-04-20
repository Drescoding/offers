package com.drescoding.offers.model;

import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
