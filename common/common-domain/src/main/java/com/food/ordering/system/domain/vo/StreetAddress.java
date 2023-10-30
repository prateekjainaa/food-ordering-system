package com.food.ordering.system.domain.vo;

import java.util.Objects;
import java.util.UUID;

public class StreetAddress {
	private UUID id;
	private String street;
	private String postalCode;
	private String city;

	public StreetAddress(UUID id, String street, String postalCode, String city) {
		super();
		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
	}

	public UUID getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, postalCode, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StreetAddress other = (StreetAddress) obj;
		return Objects.equals(city, other.city) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(street, other.street);
	}

}
