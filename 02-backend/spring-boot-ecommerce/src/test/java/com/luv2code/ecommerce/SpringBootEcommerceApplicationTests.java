package com.luv2code.ecommerce;

import com.luv2code.ecommerce.dao.CustomerRepository;
import com.luv2code.ecommerce.dao.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringBootEcommerceApplicationTests {
	private final CustomerRepository customerRepository;
	private final ProductRepository productRepository;

	@Autowired
	SpringBootEcommerceApplicationTests(ProductRepository productRepository, CustomerRepository customerRepository){
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testAutowired() {
		assertNotNull(productRepository);
		assertNotNull(customerRepository);
	}

	@Test
	void checkProducts(){
		//There are only 100 products these statements must be true
		assertEquals(100, productRepository.count());
		assertFalse(productRepository.existsById((long) 101));
		assertTrue(productRepository.existsById((long)1));
	}

	/*
	@Test
	void testNativeQuery(){
		//There are 100 products so the last five product id's must be 100, 99, 98, 97, and 96
		Set<Product> products = productRepository.findLastFiveProducts();
		products.forEach(product ->assertTrue(product.getId() > 95));
	} */

	@Test
	void checkCustomers(){
		assertTrue(customerRepository.existsById((long)1));
		assertFalse(customerRepository.existsById((long) 2));
	}

}

