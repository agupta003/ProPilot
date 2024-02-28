package com.itservicesone.training.spring.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.AbstractSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.DB2SequenceMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.PostgreSQLSequenceMaxValueIncrementer;

public class CustomerDAO implements ICustomerDAO {

	private DataFieldMaxValueIncrementer incrementer;

	/**
	 * This demonstrates how to use auto incrementer. You can wire (inject) any
	 * one of the following implementations of DataFieldMaxValueIncrementer
	 * through your application.xml. Well, you can wire your own implementation
	 * as well. Also see the usage of this incrementer in
	 * {@link #insertCustomer()}
	 * <ol>
	 * <li>
	 * {@link AbstractDataFieldMaxValueIncrementer}</li>
	 * <li>
	 * {@link AbstractSequenceMaxValueIncrementer}</li>
	 * <li>
	 * {@link DB2SequenceMaxValueIncrementer}</li>
	 * <li>
	 * {@link HsqlMaxValueIncrementer}</li>
	 * <li>
	 * {@link MySQLMaxValueIncrementer}</li>
	 * <li>
	 * {@link OracleSequenceMaxValueIncrementer}</li>
	 * <li>
	 * {@link PostgreSQLSequenceMaxValueIncrementer}
	 * <li>
	 * </ol>
	 * 
	 * @param incrementer
	 */
	public void setIncrementer(DataFieldMaxValueIncrementer incrementer) {
		this.incrementer = incrementer;
	}

	public Properties getCustomerTypesProps() {
		return customerTypesProps;
	}

	public void setCustomerTypesProps(Properties customerTypesProps) {
		this.customerTypesProps = customerTypesProps;
	}

	public Map getCustomerTypesMap() {
		return customerTypesMap;
	}

	public Properties customerTypesProps;

	public void setCustomerTypesMap(Map customerTypesMap) {
		this.customerTypesMap = customerTypesMap;
	}

	private List customerTypes;

	private Map customerTypesMap;

	public List getCustomerTypes() {
		return customerTypes;
	}

	public void setCustomerTypes(List customerTypes) {
		this.customerTypes = customerTypes;
	}

	public void create() {

		System.out.println(" Creating Customer ");

	}

	/**
	 * Uses the incrementer to the get the max next value
	 */
	public void insertCustomer() {
		int newCustomerId = incrementer.nextIntValue();
		// Use this while creating a new row

	}

}
