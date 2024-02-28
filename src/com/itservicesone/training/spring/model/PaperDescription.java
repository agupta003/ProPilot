package com.itservicesone.training.spring.model;

public class PaperDescription {
	
	private int gsm;
	private String size1;
	private String size2;

	public PaperDescription(int gsm, String size1, String size2) {
		this.gsm  = gsm;
		this.size1 = size1;
		this.size2 = size2;
	}
	public int getGsm() {
		return gsm;
	}

	public void setGsm(int gsm) {
		this.gsm = gsm;
	}

	public String getSize1() {
		return size1;
	}

	public void setSize1(String size1) {
		this.size1 = size1;
	}

	public String getSize2() {
		return size2;
	}

	public void setSize2(String size2) {
		this.size2 = size2;
	}

}
