package com.itservicesone.training.spring.s2.topic1.containers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.itservicesone.training.spring.s1.topic2.simpleaop.TheTargetInterface;

/**
 * This class illustrates the concept of Containers in Spring. There are several
 * containers out of which two are most extensively used viz. BeanFactory and
 * ApplicationContext. There are several implementations of ApplicationContext.
 * BeanFactory can be used where there are scarce resoures. ApplicationContext
 * is more advanced and offers features that are beyond BeanFactory like
 * resolving messages, publishing life cycle events and generic way to load
 * resources like images. <br>
 * <br>
 * There are implementations for each one of these containers that are used in
 * this example. <br>
 * <br>
 * Note that if you use ClassPathXmlApplicationContext implementation of
 * ApplicationContext then the .xml file must be in src folder as this
 * implementation looks for the file in class path.<br>
 * <br>
 * Each of the implementations demonstrated in this class will result into a
 * different Container Instance. You will hardly find a reason to run two
 * containers in one application simultaneously.
 * 
 * 
 * @author <b>Muhammed Shakir</b>
 */
public class TestContainers {

	public static void main(String[] args) {

		// BeanFactory Container

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
				"application.xml"));

		// Following picks up the xml from FileSystem hence must be in project
		// folder

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"application.xml");

		// ApplicationContext ctx1 = new ClassPathXmlApplicationContext(
		// "hello.xml");
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
