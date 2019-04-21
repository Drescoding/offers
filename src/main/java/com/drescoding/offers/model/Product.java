package com.drescoding.offers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String currency;
  private Double price;
  private String description;
  private String expiryDate;
  private Boolean valid;
}
