package com.food.ordering.system.order.service.domain.vo;

import java.util.UUID;

import com.food.ordering.system.domain.vo.BaseId;

public class TrackingId extends BaseId<UUID>{

	public TrackingId(UUID value) {
		super(value);
	}

}
