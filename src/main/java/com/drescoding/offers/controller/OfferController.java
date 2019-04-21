package com.drescoding.offers.controller;

import java.util.List;

import com.drescoding.offers.model.Product;
import com.drescoding.offers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

  @Autowired
  ProductService productService;

  @GetMapping("/products")
  private List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/product/{id}")
  private Product getProduct(@PathVariable("id") int id) {
    return productService.getProductById(id);
  }

  @GetMapping("/productName/{name}")
  private List<Product> getProduct(@PathVariable("name") String name) {
    return productService.getProductByName(name);
  }

  @DeleteMapping("/product/{id}")
  private void deletePerson(@PathVariable("id") int id) {
    productService.delete(id);
  }

  @PostMapping("/addProduct")
  private int addProduct(@RequestBody Product product) {
    productService.saveOrUpdate(product);
    return product.getId();
  }
}
