package com.example.cafe.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class PaymentDTO {
	
	private String customerId;
	private long orderId;
	private PaymentStatus status;
	private double amount;
	private PaymentType paidBy;
	public PaymentDTO( String customerId, long orderId, PaymentStatus status, double amount, PaymentType paidBy) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.status = status;
		this.amount = amount;
		this.paidBy = paidBy;
	}
	public PaymentDTO() {
		super();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PaymentType getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(PaymentType paidBy) {
		this.paidBy = paidBy;
	}
	@Override
	public String toString() {
		return "Payment [customerId=" + customerId + ", orderId=" + orderId + ", status="
				+ status + ", amount=" + amount + ", paidBy=" + paidBy + "]";
	}
	
	

}
