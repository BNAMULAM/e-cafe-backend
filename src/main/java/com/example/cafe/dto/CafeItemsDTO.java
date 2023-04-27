package com.example.cafe.dto;

import javax.persistence.Enumerated;
import javax.validation.constraints.Min;

public class CafeItemsDTO {
	
	private String name;
	private String details;
	private String imageUrl;
	@Enumerated()
	private ItemType type;
	@Min(value=1,message="mminimun value is 1")
	private double amount;
	
	public CafeItemsDTO( String name, String details, String imageUrl, ItemType type, double amount) {
		super();
		this.name = name;
		this.details = details;
		this.imageUrl = imageUrl;
		this.type = type;
		this.amount = amount;
	}
	public CafeItemsDTO() {
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
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CafeItems [name=" + name + ", details=" + details + ", imageUrl=" + imageUrl + ", type="
				+ type + ", amount=" + amount + "]";
	}
	
	
	

}
