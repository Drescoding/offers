package com.drescoding.offers.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> getProductByName(String name);
}
