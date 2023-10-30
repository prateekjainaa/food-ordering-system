package com.food.ordering.system.domain.vo;

import java.util.Objects;

public abstract class BaseId<ID> {
	
	private final ID value;

	public BaseId(ID value) {
		this.value = value;
	}

	public ID getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseId other = (BaseId) obj;
		return Objects.equals(value, other.value);
	}
	
	
	

}
