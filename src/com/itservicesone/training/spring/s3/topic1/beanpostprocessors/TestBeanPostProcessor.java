package com.itservicesone.training.spring.s3.topic1.beanpostprocessors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestBeanPostProcessor {

	/**
	 * BeanPostProcessor performs postprocessing on a bean after it has been
	 * loaded. If you are using a bean factory container then use
	 * <code>factory.addBeanPostProcessor(new MyBeanPostProcessor());</code>
	 * else if you are using the ApplicationContext then simply declare the
	 * MyBeanPostProcessor as bean
	 * 
	 * @see MyBeanPostProcessor
	 * @author <b>Muhammed Shakir</b>
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"application.xml");

		ctx.getBean("productService");

	}

}
