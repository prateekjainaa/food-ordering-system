package com.food.ordering.system.order.service.domain.event;

import java.time.ZonedDateTime;

import com.food.ordering.system.domain.event.DomainEvent;
import com.food.ordering.system.order.service.domain.entity.Order;

public class OrderEvent implements DomainEvent<Order> {

	protected final Order order;
	protected final ZonedDateTime dateTime;

	public OrderEvent(Order order, ZonedDateTime dateTime) {
		super();
		this.order = order;
		this.dateTime = dateTime;
	}

	public Order getOrder() {
		return order;
	}

	public ZonedDateTime getDateTime() {
		return dateTime;
	}

}