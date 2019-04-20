package com.drescoding.offers.model;

import java.time.LocalDate;

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
  private LocalDate expiryDate;
  @NonNull
  private Boolean valid;
  @NonNull
  private String currency;
  @NonNull
  private Double price;
}
