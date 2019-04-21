package com.drescoding.offers.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.drescoding.offers.model.Product;
import com.drescoding.offers.service.ProductRepository;
import com.drescoding.offers.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class ProductServiceTest {

  @Before
  public void initialise() {

  }

  @Test
  public void getProductByNameTest() {
    //Given
    Product product1 = new Product(1, "Dress", "EUR", 10.0, "Nice dress", "10/11/2019", true);
    List<Product> listOfProducts = new ArrayList<Product>();
    listOfProducts.add(product1);

    ProductRepository productRepository = mock(ProductRepository.class);
    when(productRepository.getProductByName("Dress")).thenReturn(listOfProducts);
    ProductService productService = new ProductService(productRepository);

    //When
    List<Product> products = productService.getProductByName("Dress");

    //Then
    assertEquals(listOfProducts, products);
  }

  @Test
  public void getProductByIdTest() {
    //Given
    Product product1 = new Product(1, "Dress", "EUR", 10.0, "Nice dress", "10/11/2019", true);
    ProductRepository productRepository = mock(ProductRepository.class);
    when(productRepository.findById(1)).thenReturn(Optional.of(product1));
    ProductService productService = new ProductService(productRepository);

    //When
    Product product = productService.getProductById(1);
    //Then
    assertEquals(product1, product);
  }

  @Test
  public void findAllTest(){
    Product product1 = new Product(1, "Dress", "EUR", 10.0, "Nice dress", "10/11/2019", true);
    List<Product> listOfProducts = new ArrayList<Product>();
    listOfProducts.add(product1);

    ProductRepository productRepository = mock(ProductRepository.class);
    when(productRepository.findAll()).thenReturn(listOfProducts);
    ProductService productService = new ProductService(productRepository);

    List<Product> products = productService.getAllProducts();

    //Then
    assertEquals(listOfProducts, products);
  }

}
