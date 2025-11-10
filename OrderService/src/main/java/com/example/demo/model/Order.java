package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {

	private long orderId;
	private long productId;
	private long quantity;

	public Order(long orderId, long productId, long quantity) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

}
