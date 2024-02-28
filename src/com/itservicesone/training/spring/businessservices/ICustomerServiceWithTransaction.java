package com.itservicesone.training.spring.businessservices;

import com.itservicesone.training.spring.model.Customer;

public interface ICustomerServiceWithTransaction {

	public void create(Customer customer);

	public void update(Customer customer);

	public void remove(Customer customer);

	public Customer read(int customerId);

}
