package com.itservicesone.training.spring.s7.topic1.ormsupport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.model.Customer;
import com.itservicesone.training.spring.model.CustomerDAO;
import com.itservicesone.training.spring.model.CustomerHibernateDAO;
import com.itservicesone.training.spring.model.CustomerHibernateDAOSupport;

/**
 * This class illustrates the integration of Spring with Hibernate. There is a
 * convenience class provided called HibernateTemplate which needs to be
 * configured. Using this class is very simple and straight forward. Please see
 * the hibernatespring.xml file to understand the configuration you need to do
 * in order to integrate Spring and Hibernate.
 * 
 * @see CustomerDAO
 * @see CustomerHibernateDAOSupport
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class TestHibernateSupport {

	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"hibernatespring.xml");

		CustomerHibernateDAO dao = (CustomerHibernateDAO) ctx
				.getBean("customerHibernateDAO");
		
		

		CustomerHibernateDAOSupport daoSupport = (CustomerHibernateDAOSupport) ctx
				.getBean("customerHibernateDAOSupport");

		Customer customer = new Customer();
		/*
		 * customer.setId(506); 
		 * customer.setName("GBM"); 
		 * dao.create(customer);
		 */

		customer = dao.read(506);

		Customer customer1 = daoSupport.read(101);

		System.out.println("Successful : " + customer.getName() + " -- " + customer1.getName());

	}

}
