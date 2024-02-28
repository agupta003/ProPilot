package com.itservicesone.training.spring.s2.topic2.basicwiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.businessservices.CustomerService;
import com.itservicesone.training.spring.businessservices.TaxManager;

public class TestBasicWiring {
	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"application.xml");

	public static void main(String[] args) {

		CustomerService customerService = (CustomerService) ctx
				.getBean("customerService");

		customerService.createCustomer();

		illustratePrototypeVsSingleton();
		illustrateInitAndDestruction();
		illustrateInnerBeans();

	}

	/**
	 * If in application.xml file the singleton property in bean element is left
	 * blank, spring will consider <b>singleton="true"</b> by default. If you
	 * specify singleton="false" then container will create a prototype of the
	 * original instance each time you ask for the bean. You would want to do
	 * this for domain objects which serve as look-up objects. Run the following
	 * function keeping singleton="true" and note that you will get the same
	 * object each time you make a call and then change the value of singleton
	 * to false and then check, you will get a different object.
	 * 
	 * Very Important: <b>The singleton is not a singleton at JVM level but a
	 * singleton at container level</b>. i.e. if you have a new container
	 * instantiated and used to retrieve the bean, you will get a new instance
	 * and not the one that was returned by the first container. Such singletons
	 * are known as <b>shared singleton</b> i.e. shared across all the clients
	 * of the same container.
	 * 
	 */
	public static void illustratePrototypeVsSingleton() {
		CustomerService customerService1 = (CustomerService) ctx
				.getBean("customerService");

		CustomerService customerService2 = (CustomerService) ctx
				.getBean("customerService");

		System.out.println(customerService1 + " -- " + customerService2);

	}

	/**
	 * <p>
	 * This is to illustrate the initialization and destruction methods that can
	 * be configured for the bean There are two ways in which you can define the
	 * initialization methods:
	 * <ol>
	 * <li>Make your bean implement InitialingBean interface and implement
	 * afterPropertiesSet(). In such a case no config is needed in
	 * application.xml</li>
	 * <li>Create a method with any name and configure it using init-method</li>
	 * </ol>
	 * Note that if you do both, then first the method implemented for
	 * InitializingBean will be executed and then the init-method (This is as
	 * per the life-cycle of the bean defined by spring)
	 * </p>
	 * <p>
	 * The destruction method also can be configured in two ways
	 * <ol>
	 * <li>Make your bean implement DisposableBean and implement the destroy
	 * method</li>
	 * <li>Configure destroy-method in application.xml</li>
	 * </ol>
	 * Note that if you use both, then first the destroy method will be called
	 * and then the configured destroy method will be called. <b>If you do not
	 * registerShutdownHook() with the Context the destroy methods will never
	 * execute. Try commenting the line that registers this hook and then run -
	 * you will see that the destroy method will not execute</b>
	 * </p>
	 * <p>
	 * <b>Note:</b> For destruction methods to work, we must use
	 * ApplicationContext container and not the BeanFactory container. This is
	 * because you will not be able to type cast the BeanFactory implementation
	 * to AbstractApplicationContext and it is only the
	 * AbstractApplicationContext which contains registerShutdownHook method
	 * </p>
	 * 
	 * @see com.itservicesone.training.spring.businessservices.TaxManager#init
	 * @see com.itservicesone.training.spring.businessservices.TaxManager#afterPropertiesSet()
	 * 
	 */
	public static void illustrateInitAndDestruction() {

		AbstractApplicationContext ctx1 = (AbstractApplicationContext) ctx;
		ctx1.registerShutdownHook();

	}

	/**
	 *Open application.xml file and note the way auditManager property of
	 * taxManager is configured for injection. This is inner bean. Note that you
	 * will now, not be able to refer to this inner bean from anywhere else in the
	 * xml. However, this will be very useful if you really do not want
	 * (intentionally or unintentionally) to use this bean out of TaxManager for
	 * e.g. if you are creating a AOP proxy you may not want the bean to be
	 * accessible directly in the container
	 * 
	 */
	public static void illustrateInnerBeans() {
		TaxManager manager = (TaxManager) ctx.getBean("taxManager");
		manager.getAuditManager().audit();

	}

}
