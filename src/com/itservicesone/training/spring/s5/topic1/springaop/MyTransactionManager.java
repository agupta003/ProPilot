package com.itservicesone.training.spring.s5.topic1.springaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * In this advice that is also known as "around" advice can be used to
 * conditionally call the target object.
 * 
 *<p>
 * The specialty of this Interceptor is that it is aopalliance compliant
 * meaning you can reuse this with any other aopalliance compatible framework in
 * the same project
 *</p>
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class MyTransactionManager implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub

		System.out.println("Starting Transaction in Around Advice (MethodInterceptor)");
		Object result = invocation.proceed();
		System.out.println("Committing Transaction");
		return result;
	}

}
