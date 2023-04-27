
package com.example.cafe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Payment {
	
	@Id
	@SequenceGenerator(name="PAYMENT_SEQ_GEN", sequenceName="PAYMENT_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYMENT_SEQ_GEN")
	private long paymentId;
	private String customerId;
	private long orderId;
	private String status;
	private double amount;
	private String paidBy;
	public Payment(String customerId, long orderId, String status, double amount, String paidBy) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.status = status;
		this.amount = amount;
		this.paidBy = paidBy;
	}
	public Payment() {
		super();
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", customerId=" + customerId + ", orderId=" + orderId + ", status="
				+ status + ", amount=" + amount + ", paidBy=" + paidBy + "]";
	}
	
	

}
