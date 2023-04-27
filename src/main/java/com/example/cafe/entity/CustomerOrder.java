package com.example.cafe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class CustomerOrder {
	
	@Id
	@SequenceGenerator(name="CORDER_SEQ_GEN", sequenceName="CORDER_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CORDER_SEQ_GEN")
	private long orderId;
	
	@OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name="order_fk",referencedColumnName="orderId")
	private List<OrderItem> order;
	private String userName;
	private boolean isOfferApplied;
	private String offerCode;
	private double tax;
	private double totalAmount;
	private double finalAmount;
	
	
	public CustomerOrder(List<OrderItem> order,  String userName, boolean isOfferApplied, String offerCode, double tax,
			double totalAmount, double finalAmount) {
		super();
		this.order = order;
		this.userName = userName;
		this.isOfferApplied = isOfferApplied;
		this.offerCode = offerCode;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.finalAmount = finalAmount;
	}
	public CustomerOrder() {
		super();
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "CustomerOrder [orderId=" + orderId + ", order=" + order + ", userName=" + userName + ", isOfferApplied="
				+ isOfferApplied + ", offerCode=" + offerCode + ", tax=" + tax + ", totalAmount=" + totalAmount
				+ ", finalAmount=" + finalAmount + "]";
	}
	
	

}
