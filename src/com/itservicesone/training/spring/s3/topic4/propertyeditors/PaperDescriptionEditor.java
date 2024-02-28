package com.itservicesone.training.spring.s3.topic4.propertyeditors;

import java.beans.PropertyEditorSupport;

import com.itservicesone.training.spring.model.PaperDescription;

/**
 * This is the custom editor that can be registered in BeanFactoryPostProcessor
 * using registerCustomEditor method on beanFactory that is passed as parameter
 * by spring to postProcessBeanFactory method or configure this in
 * application.xml file
 * <p>
 * You must override atleast the setAsText method for the framework to give you
 * desired behavior
 * </p>
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class PaperDescriptionEditor extends PropertyEditorSupport {

	/**
	 * Overriden method that converts text to PaperDescription object
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		int gsm = Integer.parseInt(text.substring(0, 2));
		String size1 = text.substring(3, 5);
		String size2 = text.substring(6, 8);
		PaperDescription description = new PaperDescription(gsm, size1, size2);
		this.setValue(description);
	}

	/*
	 * @Override public String getAsText() { // TODO Auto-generated method stub
	 * return super.getAsText(); }
	 */

}
