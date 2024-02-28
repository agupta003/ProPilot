package com.itservicesone.training.spring.s6.topic1.jdbcsupport;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.model.BillingRateDAO;
import com.itservicesone.training.spring.model.Customer;
import com.itservicesone.training.spring.model.CustomerByNameFinder;
import com.itservicesone.training.spring.model.CustomerCreator;

/**
 * This application demonstrate the use of JdbcTemplate. The JdbcTemplate Class
 * in spring is designed based on GOF Template Pattern. Right from getting the
 * driver loaded to handling the JDBC Specific Exceptions is all done by the
 * this template class. The steps thats needs to be hooked into the template
 * method are those that needs the actual sql & its parameters to execute.
 * 
 * @see BillingRateDAO
 * @author <b>Muhammed Shakir</b>
 */
public class TestJDBCSupport {

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"jdbcSupport.xml");

	/**
	 * Each one of the methods executed on the BillingRateDAO is very
	 * significant and explains a new topic. Uncomment and see the javadoc
	 * against each method. Note that you will have to create BillingRate table
	 * for examples related to BillingRate to work
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		BillingRateDAO billingRateDAO = (BillingRateDAO) ctx
				.getBean("billingRateDAO");

		 billingRateDAO.updateRate();

		billingRateDAO.getAllBillingRates();
		billingRateDAO.getBillingRate(101);
		billingRateDAO.getRate(101);
		billingRateDAO.getTotalDefinedBillingRates();
		billingRateDAO.reviseBillingRates(new ArrayList());
		billingRateDAO.executeStoreProcedure();

		DataSource ds = (DataSource) ctx.getBean("driverManagerDataSource");
		
		
		// CustomerCreator creator = new CustomerCreator(ds);
		// creator.insert(new Customer(505, "SBM"));

		CustomerByNameFinder finder = new CustomerByNameFinder(ds);
		Customer customer = (Customer) finder.execute(new Object[] { 505 })
				.get(0);
		System.out.println(customer.getName());

		System.out.println("Successfully Executed");

	}

}
