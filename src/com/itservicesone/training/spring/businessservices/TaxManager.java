package com.itservicesone.training.spring.businessservices;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TaxManager implements InitializingBean, DisposableBean {
	
	public TaxAuditManager getAuditManager() {
		return auditManager;
	}

	public void setAuditManager(TaxAuditManager auditManager) {
		this.auditManager = auditManager;
	}

	private TaxAuditManager auditManager;
	

	/**
	 * This method is configured as init-method in the application.xml file This
	 * method will be called immediately after all the dependency injection is
	 * done. Will be called after afterPropertiesSet
	 * 
	 * @author <b>Muhammed Shakir</b>
	 */
	public void init() {

		System.out.println("This is initialization");
	}

	/**
	 * This is the method that is configured as destory-method in
	 * application.xml This method will be called before the shutdown of
	 * container.
	 * 
	 * @author <b>Muhammed Shakir</b>
	 */
	public void destroy() {
		System.out.println("Clean up code in destroy goes here");
	}

	public void configuredDestroy() {
		System.out.println("Clean up code in configured destroy goes here");

	}

	/**
	 * Will be called before init()
	 * 
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("In afterPropertiesSet()");

	}

}
