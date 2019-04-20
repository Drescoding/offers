package com.drescoding.offers.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Response {

  @NonNull
  private String description;
  @NonNull
  private Date expiryDate;
  @NonNull
  private Boolean valid;
  @NonNull
  private String currency;
  @NonNull
  private Double price;
}
