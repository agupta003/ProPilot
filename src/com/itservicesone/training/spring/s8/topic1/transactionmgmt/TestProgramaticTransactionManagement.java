package com.itservicesone.training.spring.s8.topic1.transactionmgmt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.itservicesone.training.spring.model.Customer;
import com.itservicesone.training.spring.model.CustomerDAOWithTransaction;

/**
 * This class demonstrates the use of HibernateTransactionManager <br>
 * <br>
 * 
 * Transaction Management in Spring supported both ways - Programmatically and
 * Declaratively. <br>
 * <br>
 * Unlike EJB-Container Management transactions, Spring Transaction Management
 * is not coupled with JTA. Spring Transaction Manager leverages the transaction
 * management capabilities of the underlying Persistency i.e. it can use
 * {@link DataSourceTransactionManager} for plan Jdbc Persistency, it will use
 * {@link HibernateTransactionManager} if Hibernate is the persistency mechanism
 * and {@link JtaTransactionManager} if there is a transaction manager offered
 * by your ejb container.<br>
 * 
 * All of these Transaction Managers implements
 * {@link PlatformTransactionManager} interface
 * <hr>
 * Please see <b>springTransaction.xml</b> file. There I have explained
 * not just Hibernate but also the mechanism of declaring other Transaction
 * Managers
 * <hr>
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class TestProgramaticTransactionManagement {

	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"springTransaction.xml");

		CustomerDAOWithTransaction dao = (CustomerDAOWithTransaction) ctx
				.getBean("customerDAOWithTransaction");
		Customer customer = new Customer(978, "ACP");
		dao.create(customer);
		
		System.out.println("Execution Complete");

	}
}
