package com.itservicesone.training.spring.model;

import java.net.URL;
import java.util.List;

public class GenericDAO implements IGenericDAO {

	public String[] getCredentials() {
		System.out.println("         Returning Credentials in GenericDAO");
		return credentials;
	}

	public void setCredentials(String[] credentials) {
		this.credentials = credentials;
	}

	private URL theURL;
	private String driver;
	private String[] credentials;

	public URL getTheURL() {
		return theURL;
	}

	public void setTheURL(URL theURL) {
		this.theURL = theURL;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * Refer to this method only while learning s5.topic1: springaop. This is
	 * the method which will be intercepted by the advice configured in
	 * application.xml file
	 * 
	 * @see MyLoggingBeforeAdvice
	 */
	@Override
	public List getResults() {
		// TODO Auto-generated method stub
		System.out.println("         Getting Results in GenericDAO");
		return null;
	}

}
