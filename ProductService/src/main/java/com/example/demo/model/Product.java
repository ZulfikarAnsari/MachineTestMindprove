package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

	private long productId;
	private String productName;
	private long productPrice;
	private long productStock;

	public Product(long productId, String productName, long productPrice, long productStock) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

}
