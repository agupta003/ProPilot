package com.itservicesone.training.spring.s9.topic1.remoting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;
import org.springframework.ejb.access.SimpleRemoteStatelessSessionProxyFactoryBean;

public class TestRemoteEJBClient {

	/**
	 * The only difference between using EJB and RMI is that for EJB it is a
	 * different Proxy i.e. {@link SimpleRemoteStatelessSessionProxyFactoryBean}
	 * and also that you need to set the jndiEnvironment Properties - see
	 * application-ejb-client.xml. Also note that you can use
	 * {@link LocalStatelessSessionProxyFactoryBean} for Local EJB(s)
	 * 
	 * @author <b>Muhammed Shakir</b>
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"application-ejb-client.xml");

		BookingService service = (BookingService) ctx.getBean("bookingService");

		service.getCustomer();

		System.out.println("Service Called Successfully......");

	}

}
