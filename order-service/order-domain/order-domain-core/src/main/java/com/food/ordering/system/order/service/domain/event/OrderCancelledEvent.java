package com.food.ordering.system.order.service.domain.event;

import java.time.ZonedDateTime;

import com.food.ordering.system.domain.event.DomainEvent;
import com.food.ordering.system.order.service.domain.entity.Order;

public class OrderCancelledEvent extends OrderEvent {
	
	public OrderCancelledEvent(Order order, ZonedDateTime dateTime) {
		super(order, dateTime);
	}	

}
