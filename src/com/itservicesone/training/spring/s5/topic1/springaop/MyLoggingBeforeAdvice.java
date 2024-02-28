package com.itservicesone.training.spring.s5.topic1.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.itservicesone.training.spring.model.GenericDAO;

/**
 * This is the class that will act as interceptor. Spring's joinpoint model is
 * built around method interceptors and this class is the advice that will be
 * introduced at pointcut declared in application.xml
 * <p>
 * <b>Please Note</b> : You cannot stop the execution of the target method
 * unless you throw an Exception from the before method here
 *</p>
 *You can simillarly implement AfterReturnAdvice for after advice
 * 
 * @see GenericDAO#getResults
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class MyLoggingBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target)
			throws Throwable {

		System.out.println("Before advice is invoked - Logging the invocation");

	}

}
