package com.example.cafe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CafeItems {
	
	@Id
	@SequenceGenerator(name="ITEM_SEQ_GEN", sequenceName="ITEM_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITEM_SEQ_GEN")
	private long id;
	private String name;
	private String details;
	private String imageUrl;
	private String type;
	private double amount;
	
	public CafeItems( String name, String details, String imageUrl, String type, double amount) {
		super();
		this.name = name;
		this.details = details;
		this.imageUrl = imageUrl;
		this.type = type;
		this.amount = amount;
	}
	public CafeItems() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CafeItems [id=" + id + ", name=" + name + ", details=" + details + ", imageUrl=" + imageUrl + ", type="
				+ type + ", amount=" + amount + "]";
	}
	
	
	

}
