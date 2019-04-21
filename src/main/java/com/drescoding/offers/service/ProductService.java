package com.drescoding.offers.service;

import java.util.ArrayList;
import java.util.List;

import com.drescoding.offers.model.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<Product>();
    productRepository.findAll().forEach(product -> products.add(product));
    return products;
  }

  public Product getProductById(int id) {
    return productRepository.findById(id).get();
  }

  public List<Product> getProductByName(String name) {
    List<Product> products = new ArrayList<Product>();
    log.debug("Product(s): "  + productRepository.getProductByName(name));
    productRepository.getProductByName(name).forEach(product -> products.add(product));
    return products;
  }

  public void saveOrUpdate(Product product) {
    productRepository.save(product);
  }

  public void delete(int id) {
    productRepository.deleteById(id);
  }


}
