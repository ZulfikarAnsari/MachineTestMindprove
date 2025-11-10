package com.example.demo.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Order;
import com.example.demo.model.Product;

@RestController
public class OrderController {

	final String URL = "http://localhost:8080/getProducts";

	@GetMapping("/order/{productId}/{quantity}")
	public ResponseEntity<String> getProducts(@PathVariable long productId, @PathVariable long quantity) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Product>> response = restTemplate.exchange(URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});

		List<Product> productList = response.getBody();

		Product productOrdered = new Product();
		productOrdered = null;
		for (Product prod : productList) {
			if (productId == prod.getProductId()) {
				productOrdered = prod;
			}
		}

		if (productOrdered != null) {
			if (productOrdered.getProductStock() < quantity) {
				return ResponseEntity.badRequest().body("Given product is out of stock");
			} else {
				Order order = new Order(1, productId, 5);
				return ResponseEntity.ok().body("Order Placed");
			}
		} else {
			return ResponseEntity.badRequest().body("Product Id is not there");
		}
	}

}
