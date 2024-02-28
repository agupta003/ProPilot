package com.itservicesone.training.spring.s2.topic3.wiringcollections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.model.ICustomerDAO;

public class TestWiringCollections {

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"application.xml");

	public static void main(String[] args) {
		
		illustrateListWiring();
		System.out.println(" --- ");
		illustrateMapWiring();

		System.out.println(" --- ");
		illustratePropsMapping();

	}

	/**
	 * Note the wiring technique used to wire List in application.xml for the
	 * bean - customerDAO Sets and Lists are wired the same way. It is just that
	 * Sets cannot have duplicate values
	 * 
	 */
	public static void illustrateListWiring() {

		ICustomerDAO dao = (ICustomerDAO) ctx.getBean("customerDAO");
		List<String> customerTypes = dao.getCustomerTypes();
		for (String type : customerTypes) {
			System.out.println(type);
		}
	}

	public static void illustrateMapWiring() {

		ICustomerDAO dao = (ICustomerDAO) ctx.getBean("customerDAO");
		Map typesMap = dao.getCustomerTypesMap();
		Set<Map.Entry> types = typesMap.entrySet();

		for (Map.Entry e : types) {
			System.out.println(e.getKey() + " -- " + e.getValue());

		}

	}

	/**
	 * In properties wiring you can only wire String entries. This is how it is
	 * different from Map Properties
	 * 
	 * @author <b>Muhammed Shakir</b>
	 */
	public static void illustratePropsMapping() {

		ICustomerDAO dao = (ICustomerDAO) ctx.getBean("customerDAO");
		Properties props = dao.getCustomerTypesProps();
		Set<Map.Entry<Object, Object>> types = props.entrySet();

		for (Map.Entry e : types) {
			System.out.println(e.getKey() + " -- " + e.getValue());

		}

	}
}
