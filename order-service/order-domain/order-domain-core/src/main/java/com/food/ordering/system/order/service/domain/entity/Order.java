package com.food.ordering.system.order.service.domain.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.food.ordering.system.domain.entity.AggregateRoot;
import com.food.ordering.system.domain.vo.CustomerId;
import com.food.ordering.system.domain.vo.Money;
import com.food.ordering.system.domain.vo.OrderId;
import com.food.ordering.system.domain.vo.OrderStatus;
import com.food.ordering.system.domain.vo.RestaurantId;
import com.food.ordering.system.domain.vo.StreetAddress;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.order.service.domain.vo.OrderItemId;
import com.food.ordering.system.order.service.domain.vo.TrackingId;

public class Order extends AggregateRoot<OrderId> {

	private final OrderId orderId;
	private final CustomerId customerId;
	private final RestaurantId restaurantId;
	private final StreetAddress deliveryAddress;
	private final Money price;
	private final List<OrderItem> items;
	private TrackingId trackingId;
	private OrderStatus orderStatus;
	private List<String> failureMessages;

	public Order(OrderId orderId, CustomerId customerId, RestaurantId restaurantId, StreetAddress deliveryAddress,
			Money price, List<OrderItem> items) {
		super(orderId);
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.deliveryAddress = deliveryAddress;
		this.price = price;
		this.items = items;
	}

	public boolean validateOrder() {
		validateInitialOrder();
		validateTotalPrice();
		validateItemsPrice();

		return false;
	}

	private void validateItemsPrice() {
		// TODO Auto-generated method stub

	}

	private void validateTotalPrice() {
		if (this.price == null || !this.price.isGreaterThanZero()) {
			throw new OrderDomainException("Price validation failed, invalid price=" + this.price.getAmount());
		}

	}

	private void validateInitialOrder() {
		if (this.getId() != null || this.orderStatus != null) {
			throw new OrderDomainException("status and Id should not already set. Order Init failed.");
		}

	}

	public void initializeOrder() {
		setId(new OrderId(UUID.randomUUID()));
		this.trackingId = new TrackingId(UUID.randomUUID());
		this.orderStatus = OrderStatus.PENDING;
		initializeOrderItems();

	}

	private void initializeOrderItems() {
		long itemId = 1l;
		for (OrderItem it : items) {
			it.initializeOrderItem(super.getId(), new OrderItemId(itemId++));
		}

	}

	public void pay() {
		if (orderStatus != OrderStatus.PENDING || orderStatus != OrderStatus.CANCELLED) {
			throw new OrderDomainException("OrderStatus is not in proper status.");
		}
		orderStatus = OrderStatus.PAID;
	}

	public void approve() {
		if (orderStatus != OrderStatus.PAID) {
			throw new OrderDomainException("OrderStatus is not in PAID status.");
		}
		orderStatus = OrderStatus.APPROVED;
	}

	public boolean initCancel(List<String> failureMessages2) {

		return false;
	}

	public boolean cancel(List<String> failureMessages2) {

		return false;
	}

	public OrderId getOrderId() {
		return orderId;
	}

	public CustomerId getCustomerId() {
		return customerId;
	}

	public RestaurantId getRestaurantId() {
		return restaurantId;
	}

	public StreetAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public Money getPrice() {
		return price;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public TrackingId getTrackingId() {
		return trackingId;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public List<String> getFailureMessages() {
		return failureMessages;
	}

}
