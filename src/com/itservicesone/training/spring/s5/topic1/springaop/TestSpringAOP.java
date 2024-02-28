package com.itservicesone.training.spring.s5.topic1.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.itservicesone.training.spring.model.IGenericDAO;

/**
 * 
 * See the configuration done in application.xml file. Also note that the bean
 * is advisedGenericDAO is declared of type
 * {@link org.springframework.aop.framework.ProxyFactoryBean}. Go to the source
 * code of ProxyFactoryBean and see createCompositeInterface method in this
 * class and note the code written in ClassUtils.createCompositeInterface method
 * - It uses jdk proxy
 * 
 * @see MyLoggingBeforeAdvice
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class TestSpringAOP {

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"application.xml");

	public static void main(String[] args) {

		IGenericDAO dao = (IGenericDAO) ctx.getBean("advisedGenericDAO");
		dao.getCredentials();

		System.out.println(" --- ");

		illustrateAroundAdvice();
		illustrateThrowsAdvice();

	}

	public static void illustrateAroundAdvice() {
		IGenericDAO dao = (IGenericDAO) ctx.getBean("advisedGenericDAO");
		dao.getResults();
	}

	/**
	 * Try removing implements ISecuritySevice from MySecurityService and
	 * comment the setting of "proxyInterfaces" property in
	 * advisedSecurityService bean. This will make spring use CGLIB instead of
	 * JDK proxy. Needless to say, you must have cglib2 jar in the classpath
	 */
	public static void illustrateThrowsAdvice() {

		ISecurityService service = (ISecurityService) ctx
				.getBean("advisedSecurityService");
		try {
			service.validate();
		} catch (ApplicationException2 e) {
			// TODO Auto-generated catch block
			System.out.println(" --- Error : " + e.getMessage());
		}

	}
}
