package com.itservicesone.training.spring.s9.topic1.remoting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestRemoteRMIClient {

	/**
	 * The client of any RMI object will have to atleast - a) Use
	 * Naming.lookup('remoteObject'); and b) catch RemoteExceptin,
	 * NotBoundException and MalformedURLException.
	 * <p>
	 * Where as accessing a remote object in Spring as simple as using a
	 * RmiProxyFactoryBean which will inturn make call to the Remote Object
	 * without any ado at your end.
	 * </p>
	 * You need to configure this bean in your application.xml file.
	 * 
	 * @author <b>Muhammed Shakir</b>
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"application-rmi-client.xml");

		BookingService service = (BookingService) ctx.getBean("bookingService");

		service.doBooking();

		System.out.println("Service Called Successfully......");

	}

}
