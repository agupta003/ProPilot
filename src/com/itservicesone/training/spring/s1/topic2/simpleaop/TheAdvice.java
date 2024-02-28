package com.itservicesone.training.spring.s1.topic2.simpleaop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * 
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class TheAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out
				.println("This is the advice before target method invocation");

	}

}
