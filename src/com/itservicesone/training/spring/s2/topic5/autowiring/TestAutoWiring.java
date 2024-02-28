package com.itservicesone.training.spring.s2.topic5.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.businessservices.InvoiceService;
import com.itservicesone.training.spring.businessservices.OrderService;

public class TestAutoWiring {

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"application.xml");

	/**
	 * Autowire can help you keep the configuration file small. Autowire is the
	 * concept where Spring will automatically try to auto inject the
	 * dependencies. It does this based on the value of autowire attribute of
	 * bean element in the config file. Autowiring can be
	 * <ol>
	 * <li><b>byName</b>: Tries to match the property name with the bean name or
	 * id in the container</li>
	 * <li><b>byType</b>: Tries to match the type of property with the type of
	 * bean in the container (If more than one bean found in the container the
	 * type of which matches the type of property then it throws
	 * <b>UnsatisfiedDependencyException</b></li>
	 * <li><b>constructor</b>: Tries to match up one or more beans in the
	 * container with the parameters <b>(parameter type)</b> of one of the
	 * constructors of the bean wired. Throws same exception in case of
	 * ambiguous bean or ambiguous constructor</li>
	 * <li><b>autodetect</b>: First tries by constructor and then by type</li>
	 * </ol>
	 * <p>
	 * <b>&lt;beans default-autowire="byName"&gt;</b> can be used to specify the
	 * default settings
	 * </p>
	 * 
	 */
	public static void main(String[] args) {
		illustrateByName();
		illustrateConstructor();

	}

	/**
	 * autowire="byName"
	 */
	private static void illustrateByName() {
		OrderService service = (OrderService) ctx.getBean("orderService");

		System.out.println("OrderDAO obtained: " + service.getOrderDAO());
	}

	/**
	 * autowire="constructor"
	 * <p>
	 * Note that the type of the parameter in the constructor must match the
	 * type of one of the beans configured
	 * </p>
	 * Uncomment the definition of invoiceDAO1 in application.xml file and then
	 * run this application. You will get UnsatisfiedDepedencyException as there
	 * are two beans of the type - InvoiceDAO which is the argument type of the
	 * constructor in InvoiceService
	 * 
	 */
	private static void illustrateConstructor() {
		InvoiceService service = (InvoiceService) ctx.getBean("invoiceService");
		System.out.println("InvoiceDAO obtained : " + service.getInvoiceDAO());
	}

}
