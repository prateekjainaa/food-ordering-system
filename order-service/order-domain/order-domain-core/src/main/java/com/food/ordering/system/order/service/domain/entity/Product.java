package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.vo.Money;
import com.food.ordering.system.domain.vo.ProductId;

public class Product extends BaseEntity<ProductId> {
	private String name;
	private Money price;
	
	public Product(ProductId id, String name, Money price) {
		super(id);
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Money getPrice() {
		return price;
	}

	public void updateWithConfirmedNameAndPrice(String name2, Money price2) {
		// TODO Auto-generated method stub
		
	}


}
