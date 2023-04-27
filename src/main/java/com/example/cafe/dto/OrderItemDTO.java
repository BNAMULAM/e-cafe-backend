package com.example.cafe.dto;

import javax.validation.constraints.Min;

public class OrderItemDTO {
	
	private long itemId;
	private boolean isCombo;
	@Min(value = 1,message="Minimum quantity should be 1")
	private int quantiy;
	private String userName;
	private boolean offerApplied;
	private String offerCode;
	
	public OrderItemDTO() {
		super();
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public boolean isCombo() {
		return isCombo;
	}
	public void setCombo(boolean isCombo) {
		this.isCombo = isCombo;
	}
	public int getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}
	@Override
	public String toString() {
		return "OrderItemDTO [itemId=" + itemId + ", isCombo=" + isCombo + ", quantiy=" + quantiy + "]";
	}
	public boolean isOfferApplied() {
		return offerApplied;
	}
	public void setOfferApplied(boolean offerApplied) {
		this.offerApplied = offerApplied;
	}
	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public OrderItemDTO(boolean isCombo, @Min(value = 1, message = "Minimum quantity should be 1") int quantiy,
			String userName, boolean offerApplied, String offerCode) {
		super();
		this.isCombo = isCombo;
		this.quantiy = quantiy;
		this.userName = userName;
		this.offerApplied = offerApplied;
		this.offerCode = offerCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	
	
}
