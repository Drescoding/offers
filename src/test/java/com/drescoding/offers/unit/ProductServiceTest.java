package com.drescoding.offers.unit;

import java.text.ParseException;
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
import org.junit.Test;

@Slf4j
public class ProductServiceTest {

  ProductRepository productRepository = mock(ProductRepository.class);
  Product product1 = new Product(1, "Dress", "EUR", 10.0, "Nice dress", "10/11/2019", true);
  List<Product> listOfProducts = new ArrayList<>();

  @Test
  public void getProductByNameTest() throws ParseException {
    //Given
    listOfProducts.add(product1);
    when(productRepository.getProductByName("Dress")).thenReturn(listOfProducts);
    ProductService productService = new ProductService(productRepository);

    //When
    List<Product> products = productService.getProductByName("Dress");

    //Then
    assertEquals(listOfProducts, products);
  }

  @Test
  public void getProductByIdTest() throws ParseException {
    //Given
    when(productRepository.findById(1)).thenReturn(Optional.of(product1));
    ProductService productService = new ProductService(productRepository);

    //When
    Product product = productService.getProductById(1);
    //Then
    assertEquals(product1, product);
  }

  @Test
  public void findAllTest() {
    //Given
    when(productRepository.findAll()).thenReturn(listOfProducts);
    ProductService productService = new ProductService(productRepository);

    //When
    List<Product> products = productService.getAllProducts();

    //Then
    assertEquals(listOfProducts, products);
  }

  @Test
  public void shouldBeCancelledAfterTheExpiryDate() throws ParseException {
    //Given
    ProductService productService = new ProductService(productRepository);
    Product expiredProduct = new Product(2, "Jeans", "EUR", 10.0, "Nice jeans", "1/1/2018", true);
    when(productRepository.findById(2)).thenReturn(Optional.of(expiredProduct));

    //When
    Product product = productService.getProductById(2);

    //Then
    assertEquals(false, product.getValid());


  }

}
