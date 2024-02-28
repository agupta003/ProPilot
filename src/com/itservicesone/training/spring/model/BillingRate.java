package com.itservicesone.training.spring.model;

public class BillingRate {

	private Integer billingRateId;
	private Object technology;
	private Object Customer;
	private Object consultant;
	private int rate;

	public Integer getBillingRateId() {
		return billingRateId;
	}

	public void setBillingRateId(Integer billingRateId) {
		this.billingRateId = billingRateId;
	}

	public Object getTechnology() {
		return technology;
	}

	public void setTechnology(Object technology) {
		this.technology = technology;
	}

	public Object getCustomer() {
		return Customer;
	}

	public void setCustomer(Object customer) {
		Customer = customer;
	}

	public Object getConsultant() {
		return consultant;
	}

	public void setConsultant(Object consultant) {
		this.consultant = consultant;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
