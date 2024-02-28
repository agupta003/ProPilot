package com.itservicesone.training.spring.model;

import java.net.URL;
import java.util.List;


public interface IGenericDAO {

	public String getDriver();

	public URL getTheURL();

	public String[] getCredentials();

	/**
	 * Consider this method only while learning s5.topic1: aopbasics
	 */
	public List getResults();
}
