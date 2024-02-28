package com.itservicesone.training.spring.model;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * This class demonstrates the use of TransactionTemplate which is wired to this
 * DAO through hibernateSpringTransaction.xml. {@link #create(Customer)} in this
 * class implements programmatic transaction with the help of the
 * transactionTemplate and a TransactionCallback. Also see the configuration of
 * {@link TransactionTemplate} in hibernateSpringTransaction.xml
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class CustomerDAOWithTransaction {

	private HibernateTemplate hibernateTemplate;
	private TransactionTemplate transactionTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	/**
	 * Note how the implementation of TransactionCallaback is hooked into the
	 * template method called execute of transactionTemplate.
	 * TransactionTemplate instance in this class gets its value from .xml
	 * config.
	 * 
	 * @param customer
	 */
	public void create(final Customer customer) {

		transactionTemplate.execute(new TransactionCallback() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub

				try {

					hibernateTemplate.save(customer);
					// Deliberately throwing so that rollback can be demonstrated
					throw new RuntimeException("Some Error");

				} catch (Exception ex) {

					status.setRollbackOnly(); // explicitly rollback if there is
					// an exception

				}

				return null; // If null is returned transaction will be
				// committed
			}

		});

	}

}
