package com.itservicesone.training.spring.s1.topic2.simpleaop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class TestAOP {

	/**
	 * This application illustrates AOP with a very simple example.It explains
	 * the important concepts of AOP viz. Target, Advice and Weaving. Weaving in
	 * Spring is done in xml that serves as the configuration file.
	 * 
	 * @see com.itservicesone.training.spring.s1.topic2.simpleaop.TheAdvice
	 * @see com.itservicesone.training.spring.s1.topic2.simpleaop.TheTargetInterface
	 * @see com.itservicesone.training.spring.s1.topic2.simpleaop.TheTarget
	 * 
	 * @author <b>Muhammed Shakir</b>
	 **/
	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
				"application.xml"));

		TheTargetInterface target = (TheTargetInterface) factory
				.getBean("target");

		target.doSomething();

	}

}
