package com.itservicesone.training.spring.s3.topic2.beanfactorypostprocessors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestBeanFactoryPostProcessor {

	
	/**
	 * This application illustrates BeanFactoryPostProcessor
	 * @see MyBeanFactoryPostProcessor
	 * @author <b>Muhammed Shakir</b>
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"application.xml");

	}

}
