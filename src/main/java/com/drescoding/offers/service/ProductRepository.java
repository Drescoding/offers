package com.drescoding.offers.service;

import java.util.List;

import com.drescoding.offers.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> getProductByName(String name);
}
