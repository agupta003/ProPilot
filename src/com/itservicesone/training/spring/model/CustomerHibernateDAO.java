package com.itservicesone.training.spring.model;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class CustomerHibernateDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;

	}

	public void create(Customer customer) {

		hibernateTemplate.save(customer);

	}

	public Customer read(Integer customerId) {

		
		Customer customer = (Customer) hibernateTemplate.get(Customer.class,
				customerId);

		return customer;

	}

}
