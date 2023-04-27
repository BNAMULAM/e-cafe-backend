package com.example.cafe.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Offer {
	
	@Id
	private String offerCode;
	private String offerType;
	private String  details;
	private boolean enabeled;
	private LocalDate date;
	private int offerValue;
	
	public Offer(String offerCode, String offerType, String details, boolean enabeled, LocalDate date, int offerValue) {
		super();
		this.offerCode = offerCode;
		this.offerType = offerType;
		this.details = details;
		this.enabeled = enabeled;
		this.date = date;
		this.offerValue = offerValue;
	}
	
	public Offer() {
		super();
	}

	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public String getOfferType() {
		return offerType;
	}
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public boolean isEnabeled() {
		return enabeled;
	}
	public void setEnabeled(boolean enabeled) {
		this.enabeled = enabeled;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getOfferValue() {
		return offerValue;
	}
	public void setOfferValue(int offerValue) {
		this.offerValue = offerValue;
	}
	@Override
	public String toString() {
		return "Offer [offerCode=" + offerCode + ", offerType=" + offerType + ", details=" + details + ", enabeled="
				+ enabeled + ", date=" + date + ", offerValue=" + offerValue + "]";
	}
	

}
