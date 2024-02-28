package com.itservicesone.training.spring.s9.topic1.remoting;

public class CalendarServiceImpl implements ICalendarService {


	
	
	@Override
	public void bookDates() {
		System.out.println("In bookDates .... ");
	}

	@Override
	public void getDates() {
		System.out.println("In getDates .... ");
	}

}
