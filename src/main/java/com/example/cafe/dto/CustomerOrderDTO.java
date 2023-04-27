package com.example.cafe.dto;

import java.util.List;

import com.example.cafe.entity.OrderItem;


public class CustomerOrderDTO {
	
	private List<OrderItem> order;
	private boolean isOfferApplied;
	private String offerCode;
	private double tax;
	private double totalAmount;
	private double finalAmount;
	
	public CustomerOrderDTO() {
		super();
	}
	public List<OrderItem> getOrder() {
		return order;
	}
	public void setOrder(List<OrderItem> order) {
		this.order = order;
	}
	public boolean isOfferApplied() {
		return isOfferApplied;
	}
	public void setOfferApplied(boolean isOfferApplied) {
		this.isOfferApplied = isOfferApplied;
	}
	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	public CustomerOrderDTO(List<OrderItem> order, boolean isOfferApplied, String offerCode, double tax,
			double totalAmount, double finalAmount) {
		super();
		this.order = order;
		this.isOfferApplied = isOfferApplied;
		this.offerCode = offerCode;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.finalAmount = finalAmount;
	}
	@Override
	public String toString() {
		return "CustomerOrderDTO [order=" + order + ", isOfferApplied=" + isOfferApplied + ", offerCode=" + offerCode
				+ ", tax=" + tax + ", totalAmount=" + totalAmount + ", finalAmount=" + finalAmount + "]";
	}
	
	

}
