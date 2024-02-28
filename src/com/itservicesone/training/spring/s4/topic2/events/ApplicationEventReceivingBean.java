package com.itservicesone.training.spring.s4.topic2.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 
 * This is the class that receives the event - a type of Listener; to be more
 * precise, ApplicationListener. 
 * 
 * @author <b></b>
 * 
 */
public class ApplicationEventReceivingBean implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(" ------- Event Received ------- ");
		System.out.println("The Event Source : " + event.getClass().getName());

		if (event instanceof OrderServicedEvent) {
			OrderServicedEvent e = (OrderServicedEvent) event;
			System.out.println("The order id is : " + e.getOrder().getId());
		}

	}

}
