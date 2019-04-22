package com.drescoding.offers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue
  private int id;

  @NotNull
  private String name;

  @NotNull
  private String currency;

  @NotNull
  private Double price;

  @NotNull
  private String description;

  @NotNull
  private String expiryDate;

  private Boolean valid;
}
