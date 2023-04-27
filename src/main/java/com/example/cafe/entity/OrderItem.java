package com.example.cafe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class OrderItem {
	
	@Id
	@SequenceGenerator(name="ORDER_SEQ_GEN", sequenceName="ORDER_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_SEQ_GEN")
	private long orderId;
	private long itemId;
	private boolean isCombo;
	private int quantiy;
	private double amount;
	public OrderItem( long itemId, boolean isCombo, int quantiy, double amount) {
		super();
		this.itemId = itemId;
		this.isCombo = isCombo;
		this.quantiy = quantiy;
		this.amount = amount;
	}
	public OrderItem() {
		super();
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", itemId=" + itemId + ", isCombo=" + isCombo + ", quantiy=" + quantiy
				+ ", amount=" + amount + "]";
	}
	
	

}
