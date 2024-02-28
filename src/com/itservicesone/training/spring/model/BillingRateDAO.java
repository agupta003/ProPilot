package com.itservicesone.training.spring.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.SqlProvider;

/**
 * This DAO demonstrates the use of JdbcTemplate. Note that we have got the
 * instance of JdbcTemplate injected in this bean (see jdbcSupport.xml). The
 * JdbcTemplate instance can be created out of spring container as well
 * 
 * <pre>
 * JdbcTemplate template = new JdbcTemplate(myDataSource);
 * </pre>
 * 
 * The dataSource can again be configured as bean in Spring or can be created
 * prorgammatically (See the class and properties in jdbcSupport.xml) <br>
 * There are several overloaded update methods of jdbcTemplate. I have
 * demonstrated 3 of them.<br>
 * <br>
 * <b>All DAO Template classes in spring are thread-safe. We only need one
 * jdbcTemplate instance for each DataSource in our application</b>
 * 
 * 
 * @see RateInsertPreparedStatementCreator
 * @see RateInsertPreparedStatementSetter
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class BillingRateDAO implements IBillingRateDAO {

	/**
	 * All DAO Template classes in spring are thread-safe. We only need one
	 * jdbcTemplate instance for each DataSource in our application
	 * 
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private JdbcTemplate jdbcTemplate;

	/**
	 * This method illustrates 3 different techniques of using the JdbcTemplate
	 * to fire dml statements to the database.
	 * <ol>
	 * <li><b>PreparedStatementCreator</b>: Using the implementation of this
	 * interface you can create a PreparedStatement out of the required sql and
	 * let the template do rest of the job
	 * {@link RateInsertPreparedStatementCreator}</li>
	 * <li><b>PreparedStatmentSetter</b>: Using this implementation you can
	 * provide the value of parameters needed to execute the statement
	 * {@link RateInsertPreparedStatementSetter}</li>
	 * <li>Using the update method that accepts 3 parameters. This technique is
	 * explained below</li>
	 * </ol>
	 * 
	 * Note the usage of update method that takes 3 arguments. First argument is
	 * the sql statement, second is the values that needs to be passed as
	 * parameters and third arguments is an array of int returning the datatypes
	 * these arguments belong to.
	 * 
	 * Also note that my dmls are for Customer table. These dml(s) should have
	 * been in CustomerDAO class - ideally.
	 */
	public void updateRate() {

		try {
			PreparedStatementCreator rateInserter = new RateInsertPreparedStatementCreator();

			// jdbcTemplate.update(rateInserter);

			/*
			 * jdbcTemplate.update(
			 * "Insert into Customer (id, name) values (?, ?)", new
			 * RateInsertPreparedStatementSetter(101, "Delloite"));
			 */

			jdbcTemplate.update(
					"Insert into Customer (id, name) values (?, ?)",
					new Object[] { 104, "Nomura" }, new int[] { Types.INTEGER,
							Types.VARCHAR });

		} catch (DataAccessException ex) {
			if (ex.getCause() == null) {
				System.out.println("The Error is : " + ex.getMessage());
			} else {
				System.out.println(ex.getCause().getMessage());
			}

		}

	}

	/**
	 * To get all BillingRates. This method demonstrates the use of RowMapper
	 * which helps mapping row in resultset to Object.
	 * 
	 * @see BillingRateRowMapper
	 * 
	 * @return
	 */
	public List<BillingRate> getAllBillingRates() {

		String sql = "Select id, consultant, technology , customer, rate from BillingRate";

		return jdbcTemplate.query(sql, new BillingRateRowMapper());

	}

	/**
	 * Consider - you want to revise billing rates client wise. In such a case
	 * you will end up doing updates en masse. <br>
	 * For this you can use BatchPreparedStatementSetter. Here is the example of
	 * using the same. <br>
	 * <br>
	 * Deliberately returning as there is no BillingRate table in my database.
	 * You create then necessary tables and test this code
	 * 
	 */
	public void reviseBillingRates(final List<BillingRate> rates) {

		// Deliberately returning only because I do not have BillingRate table
		// in the database.
		if (true) {

		}

		BatchPreparedStatementSetter settter = new BatchPreparedStatementSetter() {

			/**
			 * This function determines the size of batch.
			 */
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return 10;
			}

			/**
			 * This method will be called for each statement that is executed
			 * (actually created and compiled). Each time this method is
			 * executed the index (second parameter) is the index of the
			 * statement that is being added to the batch
			 * 
			 */
			@Override
			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				BillingRate rate = rates.get(i);
				ps.setObject(1, rate.getConsultant());
				ps.setObject(2, rate.getCustomer());
				ps.setObject(3, rate.getTechnology());

			}

		};

		jdbcTemplate
				.batchUpdate(
						"Update BillingRate set rate = rate + 1500 where consultant = ? and customer = ? and technology = ?",
						settter);

	}

	/**
	 * This method demonstrates the use of RowCallbackHandler which helps
	 * process the row. This interface when implemented, provides hook for
	 * processing the row i.e. This method is called each time next method is
	 * called by the template on the ResultSet. The result passed as parameter
	 * to the processRow method can be used to extract the data and process it
	 * as per requirement. Here we have put the data in BillingRate Object and
	 * returned back the same.
	 * 
	 */
	public BillingRate getBillingRate(final Integer billingRateId) {

		String sql = "Select billingRateId, consultant, technology, customer, rate from BillingRate where billingRateId = ?";
		final BillingRate rate = new BillingRate();
		final Object parameters[] = new Object[] { billingRateId };
		jdbcTemplate.query(sql, parameters, new RowCallbackHandler() {

			/**
			 * This method will be called for each row in the ResultSet.
			 */
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				rate.setBillingRateId(rs.getInt(1));
				rate.setConsultant(rs.getInt(2));
				rate.setCustomer(rs.getInt(3));
				rate.setRate(rs.getInt(4));
			}

		});

		return rate;
	}

	/**
	 * A simple method of JdbcTemplate to get single value results
	 */
	@Override
	public int getTotalDefinedBillingRates() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForInt("Select count(*) from BillingRate");
	}

	/**
	 * To get single rate. Note that the last parameter can be any class i.e.
	 * you can also return a string, a double, a date and so on - hence the name
	 * of jdbcTemplate: queryForObject.
	 */
	@Override
	public int getRate(int rateId) {
		// TODO Auto-generated method stub
		return (Integer) jdbcTemplate.queryForObject(
				"Select rate from BillingRate where billingRateId = ?",
				new Object[] { rateId }, Integer.class);

	}

	/**
	 * This is the example of how to execute a stored procedure in spring using
	 * JdbcTemplate Note the usage of CallableStatementCallback. The
	 * implementation of doInCallableStatement can execute the store procedure
	 * actually created by template method and perform any required processing
	 * 
	 */
	public void executeStoreProcedure() {
		CallableStatementCallback c = new CallableStatementCallback() {

			public Object doInCallableStatement(CallableStatement cs)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				cs.execute();
				return null;
			}

		};
		jdbcTemplate.execute(" {archive_billing_rates}", c);
	}

}

/**
 * This implementation acts as a hook to the update method. Update method is a
 * template method which executes series of steps in algorithm that executes a
 * DML. This hook provides the PreparedStatement to the udpate method. Update
 * method then executes it handling all the possible SQLExceptions and wrapping
 * it up (if any is thrown runtime) up in the DataAccesseException heirarchy. <br>
 * The SqlProvider interface is only so that the SQL statement that is executed
 * is returned back to the update method that will log the executed sql. This
 * can be very helpful in debugging while developing your application
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
class RateInsertPreparedStatementCreator implements PreparedStatementCreator,
		SqlProvider {

	String sql = "Insert into customer (id, name) values (102, 'CGI')";

	@Override
	public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException {
		return con.prepareStatement(sql);

	}

	@Override
	public String getSql() {
		// TODO Auto-generated method stub

		// Implementation of SqlProvider only for logging purpose. Spring will
		// log the SQL Statment Returned;
		return sql;
	}

}

/**
 * This is yet another hook. This hook implementation is provided as second
 * parameter to the update method that takes SQL as the first parameter. The
 * values returned back is set as parameters to the sql statement. This is more
 * elegant way of working with the template if the arguments are decided run
 * time
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */

class RateInsertPreparedStatementSetter implements PreparedStatementSetter {

	private int id;
	private String name;

	public RateInsertPreparedStatementSetter(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setInt(1, id);
		ps.setString(2, name);

	}

}

/**
 * 
 * This class helps map the result in ResultSet i.e the row to Entity Object.
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
class BillingRateRowMapper implements RowMapper {

	/**
	 * This method must return the Entity Object the state of which must be
	 * populated from the resultset. <br>
	 * <br>
	 * <b>Very Important:</b> This RowMapper can now be reused serveral times
	 * while executing different queries for the same table
	 */
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		BillingRate rate = new BillingRate();

		rate.setBillingRateId(rs.getInt(1));
		/*
		 * Write rest of the setter methods to set the state of BillingRate
		 * Object
		 */

		return rate;

	}

}
