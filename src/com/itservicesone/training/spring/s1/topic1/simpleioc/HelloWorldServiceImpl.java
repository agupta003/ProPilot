package com.itservicesone.training.spring.s1.topic1.simpleioc;

public class HelloWorldServiceImpl implements HelloWorldService {

	private String message;
	private int number;

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public void setMessage(String message) {
		this.message = message;

	}

	
	@Override
	public void printMessage() {
		System.out.println(message + " Number is : " + number);

	}

}
