package com.example.cafe.dto;

import javax.persistence.Enumerated;
import javax.validation.constraints.Min;

public class CafeComboDTO {
	
	private String name;
	private String details;
	private String imageUrl;
	@Enumerated()
	private ComboType type;
	@Min(value=1,message="mminimun value is 1")
	private double amount;
	
	public CafeComboDTO(String name, String details, String imageUrl, ComboType type, double amount) {
		super();
		this.name = name;
		this.details = details;
		this.imageUrl = imageUrl;
		this.type = type;
		this.amount = amount;
	}
	public CafeComboDTO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public ComboType getType() {
		return type;
	}
	public void setType(ComboType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CafeItems [ name=" + name + ", details=" + details + ", imageUrl=" + imageUrl + ", type="
				+ type + ", amount=" + amount + "]";
	}
	
	
	

}
