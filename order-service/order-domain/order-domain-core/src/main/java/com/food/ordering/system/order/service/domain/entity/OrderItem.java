package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.vo.Money;
import com.food.ordering.system.domain.vo.OrderId;
import com.food.ordering.system.order.service.domain.vo.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {

	private OrderItemId orderItemId;
	private OrderId orderId;
	private final Product product;
	private final int quantity;
	private final Money price;
	private final Money subTotal;

	public OrderItem(OrderItemId id, OrderId orderId, Product product, int quantity, Money price, Money subTotal) {
		super(id);
		this.orderId = orderId;
		this.orderItemId = id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
	}
	
	public void initializeOrderItem(OrderId id, OrderItemId orderItemId) {
		this.orderId = id;
		this.orderItemId = orderItemId;
	}

	public OrderId getOrderId() {
		return orderId;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public Money getPrice() {
		return price;
	}

	public Money getSubTotal() {
		return subTotal;
	}

}
