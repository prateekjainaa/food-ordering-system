package com.food.ordering.system.order.service.domain.entity;

import java.util.List;

import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.vo.RestaurantId;

public class Restaurant extends BaseEntity<RestaurantId> {
	
	private boolean active;
	private List<Product> products;

	public Restaurant(RestaurantId id) {
		super(id);
	}
	
	public boolean isActive() {
		return true;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return products;
	}
	

}
