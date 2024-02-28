package com.itservicesone.training.spring.s9.topic1.remoting;

import java.rmi.Naming;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestRemoting {
	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"application-rmi-server.xml");

	/**
	 * Writing an RMI Object entails following
	 * <ol>
	 * <li>Create a service interface extending java.rmi.Remote</li>
	 * <li>Write implementation class that must and must extend from
	 * java.rmi.UnicastRemoteObject</li>
	 * <li>Your service method must throw RemoteException</li>
	 * <li>Then you need to generate client stub and server skeleton using
	 * <b>rmic</b></li>
	 * <li>Finally you will have to start the registry and bind the service
	 * implementation to a name in the registry</li>
	 * </ol>
	 * A lot of work.
	 * <p>
	 * In Spring, however,
	 * <ol>
	 * <li>You will simply create a POJO implementing a plain server interface
	 * and declare it as a bean in application.xml</li>
	 * <li>Declare a bean (can be unnamed) in application.xml file with class as
	 * org.springframework.remoting.rmi.RmiServiceExporter - This
	 * RmiServerExporter does the magic. You only need to set the some
	 * significant properties of this bean and you are done. The properties are
	 * <ol>
	 * <li>service: reference to bean that offers remote service in our case
	 * calendarService</li>
	 * <li>serviceName: this will be the name bound to rmi object created by
	 * Spring</li>
	 * <li>serviceInterface: This is the fully qualified name of Interface that
	 * the service is implementing</li>
	 * </ol>
	 * </li>
	 * </ol>
	 * It is needless to say that this application which has an RMI object will
	 * be blocking as the object is registered in the register and ready accept
	 * requests
	 * <p>
	 * When network constraints (firewalls etc.) are a factor you may use Hesian
	 * and Burlap api(s) which also provide remoting services. While Hesian
	 * transfers data in binary format, Burlap transfers data in XML format. The
	 * XML format is very simple and is not dependent on SOAP or IDL language.
	 * Note that both these api(s) use proprietary object serialization
	 * mechanism. Spring does provide remoting wrappers for these api(s) as well
	 * </p>
	 * 
	 * @author <b>Muhammed Shakir</b>
	 */

	public static void main(String[] args) {

		System.out.println("Will Block");

	}

}
/*
*/