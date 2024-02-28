package com.itservicesone.training.spring.model;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * This class demonstrates the use of SqlUpdate Class which can be used to
 * create SQLOperations as Objects. You can delcare an instance of this class in
 * a DAO Class since all of these object are thread safe
 * 
 * @see #CustomerCreator(DataSource) CreateCustomer
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class CustomerCreator extends SqlUpdate {

	/**
	 * Note that the order in which delcareParameter is executed is important.
	 * First execution will be set as the first parameter. Compiling the query
	 * is important which will precompile the query so that it can be executed
	 * with different parameters without recompiling again and again.
	 * 
	 * @param ds
	 */
	public CustomerCreator(DataSource ds) {
		setDataSource(ds);
		setSql("Insert into Customer (id, name) values (?, ?)");
		declareParameter(new SqlParameter(Types.NUMERIC));
		declareParameter(new SqlParameter(Types.VARCHAR));
		compile();

	}

	public int insert(Customer customer) {

		Object parameters[] = new Object[] { customer.getId(),
				customer.getName() };
		return super.update(parameters);

	}

}
