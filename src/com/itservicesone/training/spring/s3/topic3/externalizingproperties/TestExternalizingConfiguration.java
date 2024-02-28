package com.itservicesone.training.spring.s3.topic3.externalizingproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.model.GenericDAO;
import com.itservicesone.training.spring.model.IGenericDAO;

/**
 * You can externalize the configuration in spring by using
 * org.springframework.beans.factory.config.PropertyPlacehlderConfigurer. Simply
 * register this bean in your application.xml file and set either the location
 * property (if one externalized file) or location(s) property (if more than one
 * externalized file). See sample in application.xml file.
 * <p>You must use ApplicationContext as the container</p>
 * 
 * @author <b>Muhammed Shakir</b>
 */
public class TestExternalizingConfiguration {

	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"application.xml");

		IGenericDAO dao = (IGenericDAO) ctx.getBean("genericDAO");

		System.out
				.println("The value of this propery is configured in jdbc.properties : "
						+ dao.getDriver());

	}

}
