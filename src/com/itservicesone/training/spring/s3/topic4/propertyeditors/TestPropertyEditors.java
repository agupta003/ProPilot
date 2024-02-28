package com.itservicesone.training.spring.s3.topic4.propertyeditors;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itservicesone.training.spring.model.IGenericDAO;
import com.itservicesone.training.spring.model.IPaperPurchaseDAO;
import com.itservicesone.training.spring.model.PaperDescription;
import com.itservicesone.training.spring.s3.topic2.beanfactorypostprocessors.MyBeanFactoryPostProcessor;

public class TestPropertyEditors {

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"application.xml");

	/**
	 * 
	 * The property <b>theURL</b> of GenericDAO was converted by spring as
	 * object. Note that it is set as string in application.xml file. Spring has
	 * used org.springframework.beans.propertyeditors.URLEditor which is a type
	 * of java.beans.PropertyEditorSupport. There are other property editors as
	 * well viz.
	 * <ol>
	 * <li>ClassEditor</li>
	 * <li>CustomDateEditor</li>
	 * <li>FileEditor</li>
	 * <li>LocaleEditor</li>
	 * <li>StringArrayPropertyEditor</li>
	 * <li>StringTrimmerEditor</li>
	 * </ol>
	 * Note that the credentials property in GenericDAO is String array and
	 * spring has appropriately converted the value in application.xml file to
	 * String Array.
	 * <p>
	 * You can also have <b>Custom Editor</b> created of your own see {@link #illustrateCustomPropertyEditor()}
	 * </p>
	 * 
	 *@author <b>Muhammed Shakir</b>
	 */
	public static void main(String[] args) {

		IGenericDAO dao = (IGenericDAO) ctx.getBean("genericDAO");

		System.out.println(dao.getTheURL().getHost());
		System.out.println(dao.getCredentials()[0] + " --  "
				+ dao.getCredentials()[1]);
		
		illustrateCustomPropertyEditor();

	}

	/**
	 * In this example I have created a custom property editor called
	 * {@link PaperDescription} which extends from
	 * java.beans.PropertyEditorSupport.
	 * <p>
	 * How will spring know about your custom editor. There are two ways of
	 * doing it
	 * <ol>
	 * <li>call registerCustomEditor method on beanFactory in
	 * {@link MyBeanFactoryPostProcessor} or</li>
	 * <li>Create a class inheriting from PropertyEditorSupport and register the editor in application.xml file. See application.xml file
	 * s3.topic4</li>
	 * </p>
	 */
	public static void illustrateCustomPropertyEditor() {
		IPaperPurchaseDAO paperPurchaseDAO = (IPaperPurchaseDAO) ctx
				.getBean("paperPurchaseDAO");
		PaperDescription desc = paperPurchaseDAO.getDefaultPaperDescription();
		System.out.println("(" + desc.getGsm() + ") --  (" + desc.getSize1()
				+ ") -- (" + desc.getSize2() + ")");

	}
}
