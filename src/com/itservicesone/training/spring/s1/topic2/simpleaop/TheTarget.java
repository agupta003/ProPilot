package com.itservicesone.training.spring.s1.topic2.simpleaop;


public class TheTarget implements TheTargetInterface {

	@Override
	public void doSomething() {

		System.out.println("In doSomething Method");

	}

	@Override
	public void doSomethingElse() {
		System.out.println("In doSomethingElse");

	}

}
