package com.itservicesone.training.spring.s4.topic2.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.model.ServiceOrder;

/**
 * You can implement ApplicationListener interface in any bean to receive the
 * application event like
 * <ol>
 * <li>ContextClosedEvent: Published when application context is closed (More
 * applicable in WebApps)</li>
 * <li>ContextRefreshEvent: Published when application context is initialized or
 * refreshed</li>
 * <li>RequestHandledEvent: Published within a <b>web</b> application context
 * when a request is handled</li>
 * </ol>
 * 
 * You can also have a bean listen to <b>custom event</b>. For this you will
 * have to create an event {@link OrderServicedEvent} of your own extending it
 * from ApplicationEvent. The Listener bean must implement ApplicationListener
 * and also must be registered in xml config file .
 * <p>
 * <b>Very Important: </b>If you want to publish any event, you need to have
 * handle of the ApplicationContext. You may need to use ApplicationContext in
 * any one of your beans so that you can publish event. So how do you get handle
 * the to ApplicationContext. It is pretty simple - make your bean implement
 * ApplicationContextAware interface which will enforce implementation of
 * setApplicationContext method. It is the job of spring to inject this
 * dependency automatically when this bean is initialized. You can initialize a
 * private variable through this method and use the ref in methods that would
 * like to publish the event (If you have worked in ejb 2.1 or lower,
 * recollect setSessionContext method)
 * </p>
 * 
 * @author <b>Muhammed Shakir</b>
 */
public class TestApplicationEvent {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"application.xml");

		TestApplicationEvent test = new TestApplicationEvent();

		OrderServicedEvent event = new OrderServicedEvent(test,
				new ServiceOrder(505));

		ctx.publishEvent(event);

	}

}
