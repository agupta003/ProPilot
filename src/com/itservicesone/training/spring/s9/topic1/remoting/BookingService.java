package com.itservicesone.training.spring.s9.topic1.remoting;

import sessionbeans.CustomerManagerRemote;

public class BookingService {

	private CustomerManagerRemote customerManager;
	private ICalendarService calendarService;

	public CustomerManagerRemote getCustomerManager() {
		return customerManager;
	}

	
	public void setCustomerManager(CustomerManagerRemote customerManager) {
		this.customerManager = customerManager;

	}

	public ICalendarService getCalendarService() {
		return calendarService;
	}

	public void setCalendarService(ICalendarService calendarService) {
		this.calendarService = calendarService;
	}

	public void doBooking() {
		calendarService.bookDates();
	}

	public void getCustomer() {
		customerManager.getCustomer();
	}

}
