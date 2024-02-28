package com.itservicesone.training.spring.s5.topic1.springaop;

import org.springframework.aop.ThrowsAdvice;

/**
 * 
 * This class can have any number afterThrowing overloaded methods. Depending on
 * which exception was thrown by the target, Spring will invoke the method.
 * Unless you throw your own exception from this advice, spring will continue
 * and throw the original exception thrown by target i.e. the original exception
 * will still be thrown
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class MyThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(InvalidUserException ex) {

		System.out
				.println(" --- InvalidUserException Exception thrown by target");

	}

	public void afterThrowing(ApplicationException2 ex) {
		System.out.println("ApplicationException2 Exception thrown by target");

	}

}
