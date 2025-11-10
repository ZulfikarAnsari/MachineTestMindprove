package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
public class ProductController {

	@GetMapping("/getProducts")
	public List<Product> getProducts() {
		List<Product> productList = new ArrayList<Product>();

		Product product1 = new Product(1, "Shirt", 1000, 100);
		Product product2 = new Product(1, "Tshirt", 800, 50);
		Product product3 = new Product(1, "Jeans", 1200, 150);
		Product product4 = new Product(1, "Shoes", 1500, 500);

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);

		return productList;
	}

}
