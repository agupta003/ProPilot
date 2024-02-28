package com.itservicesone.training.spring.s4.topic2.events;

import org.springframework.context.ApplicationEvent;

import com.itservicesone.training.spring.model.ServiceOrder;

/**
 * This must inherit from ApplicationEvent and must implement a constructor
 * which will have explicit call made to constructor of super class to set the
 * source. You can have other parameters in the constructor to set the payload
 * which can be used by the bean receiving this event
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class OrderServicedEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServiceOrder order = null;

	public OrderServicedEvent(Object source, ServiceOrder order) {
		super(source);
		// TODO Auto-generated constructor stub
		this.order = order;
	}

	public ServiceOrder getOrder() {
		return this.order;
	}

}
