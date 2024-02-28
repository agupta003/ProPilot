package com.itservicesone.training.spring.s1.topic1.simpleioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * 
 * This class illustrates simple IOC in Spring. The spring factory used here is
 * BeanFactory
 * 
 * @author <b></b>
 * 
 */
public class TestIOC {

	public static void main(String[] args) throws Exception {

		Resource resource = new FileSystemResource("application.xml");

		BeanFactory factory = new XmlBeanFactory(resource);

		HelloWorldService service = (HelloWorldService) factory
				.getBean("helloWorldService");

		service.printMessage();
		

	}

}
