package com.drescoding.offers.unit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import com.drescoding.offers.model.Product;
import com.drescoding.offers.service.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

  @Autowired
  private ProductRepository productRepository;

  @Before
  public void initialize(){
    productRepository.deleteAll();
  }

  @Test
  public void addAndFindByNameANewProduct() {
    //Given
    Product product = new Product(1, "Dress", "EUR", 10.0, "Nice dress", "10/11/2019", true);

    //When
    productRepository.save(product);

    //Then
    List<Product> products = productRepository.getProductByName("Dress");
    assertEquals("Dress", products.get(0).getName());
  }

  @Test
  public void add2ProductsAndDelete1() {
    //Given
    Product product1 = new Product(1, "Dress", "EUR", 10.0, "Nice dress", "10/11/2019", true);
    Product product2 = new Product(2, "Top", "EUR", 20.0, "Nice top", "10/12/2019", true);

    //When
    productRepository.save(product1);
    productRepository.save(product2);
    productRepository.delete(product1);

    //Then
    List<Product> products = new ArrayList<>();
    productRepository.findAll().forEach(product -> products.add(product));

    assertEquals(1, products.size());

  }

  @Test
  public void updateProduct() {
    //Given
    Product product1 = new Product(1, "Dress", "EUR", 10.0, "Nice dress", "10/11/2019", true);
    Product product2 = new Product(1, "Top", "EUR", 20.0, "Nice top", "10/12/2019", true);

    //When
    productRepository.save(product1);
    productRepository.save(product2);

    //Then
    List<Product> products = new ArrayList<>();
    productRepository.findAll().forEach(product -> {
      if (product.getId() == 1) {
        products.add(product);
      }
    });

    assertEquals("Top", products.get(0).getName());
    assertEquals(1, products.size());

  }
}

