package com.itservicesone.training.spring.s8.topic1.transactionmgmt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttributeSource;

import com.itservicesone.training.spring.businessservices.ICustomerServiceWithTransaction;
import com.itservicesone.training.spring.model.Customer;

/**
 * Spring's declarative transaction is based on AOP Framework. This is a
 * natural-fit because Transaction Management is a cross cutting concern. Spring
 * offers this service through a Proxy (as usual) and this time the name of the
 * proxy class is TransactionProxyFactoryBean. As seen in earlier tutorial on
 * AOP, these ProxyFactoryBean(s) takes in which interface it is supposed to
 * proxy and also the target class that will be proxied - so is the case with
 * TransactionProxyFactoryBean. However, there are two additional properties
 * that you need to set to this proxy bean - 1) <b><u>transactionManager</u></b>
 * & 2) <b><u>transactionAttributeSource</u></b> (From here onwards, I suggest
 * you open springTransaction.xml file and keep peeping into it to see the
 * config I have done while reading this explanation)<br>
 * <br>
 * <b>transactionManager:</b> property refers to TransactionManager bean which
 * is as same as the one already configured for programmatic transaction.<br>
 * <b>transactionSourceAttribute:</b> property specifies the transaction
 * management behavior to be applied to the methods of the target of
 * TransactionProxyFactoryBean. The behavior includes the following transaction
 * related parameters:
 * <ol>
 * <li><b>Propagation Behavior</b>
 * <table cellspacing="10" style="border: 1px solid blue">
 * <tr style="background-color: blue; color: white">
 * <td>Propagation Behavior</td>
 * <td>Translates to</td>
 * </tr>
 * <tr>
 * <td>PROPAGATION_MANDATORY</td>
 * <td>Method must run within clients transaction. If the client has not started
 * a transaction, manager will throw and exception</td>
 * </tr>
 * <tr>
 * <td>PROPAGATION_NESTED</td>
 * <td>Method will be running in a nested transaction. The nested transaction
 * can be committed or rolledback without effecting the status of enclosing
 * transaction. If there is no enclosing transaction then behaves like
 * PROPAGAION_REQUIRED. Note that this must be supported by Resource Manager</td>
 * </tr>
 * <tr>
 * <td>PROPAGATION_NEVER</td>
 * <td>Method will never run in a transaction. If client has started a
 * transaction, manager will throw an exception</td>
 * </tr>
 * <tr>
 * <td>PROPAGATION_NOT_SUPPORTED</td>
 * <td>Method will never run in a transaction but also will not throw an
 * exception if client has started one. Manager will simple suspend the
 * transaction started by client</td>
 * </tr>
 * <tr>
 * <td>PROPAGATION_REQUIRED</td>
 * <td>If the client has started a transaction, the method will run in clients
 * transaction; if not then manager will start a new transaction. This is the
 * perfect choice for most of your needs</td>
 * </tr>
 * <tr>
 * <td>PROPAGATION_REQUIRES_NEW</td>
 * <td>Method will always run in its own transaction. If the client has started
 * one, then it will suspend client's transaction and start a new one.</td>
 * </tr>
 * <tr>
 * <td>PROPAGATION_SUPPORTS</td>
 * <td>If the client has started a transaction, it participates in it or else
 * simple continues without a transaction</td>
 * </tr>
 * </table>
 * </li>
 * <li><b>Isolation Level:</b> The second transaction behavior related parameter
 * is the Isolation Level which sets the concurrency mechanism. In any
 * enterprise application, there will be 'n' number of concurrent users. These
 * concurrent users will be reading, inserting, deleting or updating rows. This
 * means that there will be many transactions concurrently running (one for each
 * client request) in your application. The isolation level set for the
 * transaction determines how changes done by one transaction will be made
 * isolated (hidden) from other transactions. There are 5 different levels that
 * can be set. These are very interesting and simple to understand
 * <table cellspacing="10" style="border: 1px solid blue">
 * <tr>
 * <td>ISOLATION_DEFAULT</td>
 * <td>Use what ever is the default isolation level of database is</td>
 * </tr>
 * <tr>
 * <td>ISOLATION_READ_UNCOMMITTED</td>
 * <td>One transaction can read the uncommitted changes done by another
 * transactions. May result in Dirty Reads, Non-Repeatable Reads and Phantom
 * Reads</td>
 * </tr>
 * <tr>
 * <td>ISOLATION_READ_COMMITTED</td>
 * <td>One transaction can read only the committed changes done by other
 * transactions. Prevents Dirty-Read but does not prevent Non-Repeatable &
 * Phantom Reads</td>
 * </tr>
 * <tr>
 * <td>ISOLATION_REPEATABLE_READ</td>
 * <td>One transaction can read only committed changes done by other
 * transactions and also will prevent non-repeatable reads. For e.g. if one
 * transaction fires a query say Select * from Customer where city="Mumbai" and
 * utilizes the name of the customer then all subsequent calls to this query
 * will produce the same (repeatable) results even if some other transaction has
 * changed the name of the customer utilized by the first transaction. This
 * isolation level will prevent dirty reads and non-repeatable reads but still
 * may have phantom reads occurring</td>
 * </tr>
 * <tr>
 * <td>ISOLATION_SERIALIZABLE</td>
 * <td>This is as same as ISOLATION_REPEATABLE_READ but will prevent Phantom
 * Reads as well. What are Phantom Reads ? - Consider you fire a query - Select
 * * from Customer where city='Mumbai' and get 10 records and while your program
 * was processing these records some other transaction has inserted a customer
 * with city = "Mumbai". Now when you re-read customers in your transaction
 * using the same query, you will get 11 rows; the one extra as a ghost a
 * phantom. The ISOLATION_SERIALIZABLE will prevent such phantom reads. This is
 * the most stringent level and usually implemented using table locks. Needless
 * to say, very expensive in terms of performace. It is as if all transactions
 * are serially executed one after the other and hence the name - SERIALIZABLE</td>
 * </tr>
 * </table>
 * </li>
 * <li><b>Read Only Hints:</b> This is the hint to transaction that it must be
 * marked as read only. The performance of read only transactions is better as
 * compared to non-read only. So if you have only queries to fire in your
 * method, you better mark it as Read Only</li>
 * <li><b>Transaction Timeout</b>: If there is a row lock or if there is a
 * long-running transaction, transaction manager will abort and rollback the
 * transaction based on timeout set</li>
 * </ol>
 * Having learn't the transaction related parameters, we must now go back to
 * TransactionAttributeSource. This is the component that declares all the above
 * mentioned parameters for one or more methods of the target (target of
 * TransactionProxyFactoryBean). This {@link TransactionAttributeSource} is an
 * interface. We will use two significant implementations of this interface 1)
 * MatchAlwaysTransactionAttributeSource & 2)
 * NameMatchTransactionAttributeSource. As the name of the implementations
 * suggest, former is to match all methods of the target i.e. the transaction
 * attributes declared will be applied to all methods of the target and later
 * allows specifying different transaction parameters/attributes to different
 * methods of the target. See the configuration of both of these in
 * springTransaction.xml
 * <hr>
 * As you might have understood by now that declarative transaction (as the name
 * says) is declarative and is configured in your application xml file. The
 * method calls will be plain and simple and thats exactly what we want - Cross
 * Cutting concerns must be factored out and must be managed by framework based
 * on config of the ApplicationContext
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class TestDeclarativeTransactionManagement {

	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"springTransaction.xml");

		ICustomerServiceWithTransaction customerService = (ICustomerServiceWithTransaction) ctx
				.getBean("transactionalCustomerService");

		
		Customer customer1 = customerService.read(566);
		customer1.setName("GBM");
		customer1.setAddress("Bahrain");
		customerService.update(customer1);
		
		
		//Customer customer2 = customerService.read(101);
		//customer2.setName("IBM USA");
		//customerService.update(customer2);
		// NameMatchTransactionAttributeSource
		System.out.println("Successful.....");

	}

}
