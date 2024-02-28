package com.itservicesone.training.spring.businessservices;

import com.itservicesone.training.spring.model.ICustomerDAO;

public class CustomerService {

	public ICustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	private ICustomerDAO customerDAO;
	
	public void createCustomer() {
		customerDAO.create();
	}

}
