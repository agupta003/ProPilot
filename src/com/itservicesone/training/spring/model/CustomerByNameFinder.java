package com.itservicesone.training.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 * This class illustrates, how to create a query as an object which can be
 * reused several times in your application
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class CustomerByNameFinder extends MappingSqlQuery {

	/**
	 * To initialize dataSource and parameter types
	 */
	public CustomerByNameFinder(DataSource ds) {

		super(ds,
				"Select id, name, address, contactperson from Customer where id = ?");
		declareParameter(new SqlParameter("id", Types.INTEGER));
		compile();

	}

	/**
	 * 
	 *A mapper that we have already learnt;
	 */
	@Override
	protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setName(rs.getString("name"));
		customer.setAddress(rs.getString("address"));
		customer.setContactPerson(rs.getString("contactperson"));
		return customer;

	}

}
