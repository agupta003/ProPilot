package com.itservicesone.training.spring.s2.topic4.wiringthroughconstructors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.businessservices.ProductService;

public class TestConstructorWiring {
	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"application.xml");

	/**
	 * This application illustrate the use of Constructors for dependency
	 * injection. Note that there can be a constructor with multiple arguments
	 * in which case "type" attribute can be used in constructor-arg element of
	 * the bean to specify the type. However, index is the attribute that is
	 * more convenient because it will work even in cases where you have a
	 * constructor with multiple arguments and all of same type.
	 * <p>
	 * Note that we have used index in our application.xml file while defining
	 * ProductService Bean dependency
	 * </p>
	 * 
	 * @author <b>Muhammed Shakir</b>
	 */
	public static void main(String[] args) {

		ProductService productService = (ProductService) ctx
				.getBean("productService");
		System.out.println(productService.getDAO());

	}

}
