package com.itservicesone.training.spring.model;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerHibernateDAOSupport extends HibernateDaoSupport {

	public void create(Customer customer) {

		getHibernateTemplate().save(customer);

	}

	public Customer read(int customerId) {

		return (Customer) getHibernateTemplate()
				.get(Customer.class, customerId);

	}

}
