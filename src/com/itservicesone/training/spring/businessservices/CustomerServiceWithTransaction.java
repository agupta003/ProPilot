package com.itservicesone.training.spring.businessservices;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itservicesone.training.spring.model.Customer;

public class CustomerServiceWithTransaction extends HibernateDaoSupport
		implements ICustomerServiceWithTransaction {

	public void create(Customer customer) {
		this.getHibernateTemplate().save(customer);

	}

	public void update(Customer customer) {

		this.getHibernateTemplate().update(customer);

		this.secondUpdate();

	}

	public void remove(Customer customer) {

	}

	public Customer read(int customerId) {
		return (Customer) this.getHibernateTemplate().get(Customer.class,
				customerId);
	}

	/**
	 * If you uncomment throw statement, the transaction will be rolled back
	 */
	public void secondUpdate() {
		Customer customer2 = this.read(101);
		customer2.setName("SBM");
		customer2.setAddress("Saudia");
		this.getHibernateTemplate().update(customer2);

		// throw new RuntimeException("Rolling Back");
	}

}
