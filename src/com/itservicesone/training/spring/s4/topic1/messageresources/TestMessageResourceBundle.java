package com.itservicesone.training.spring.s4.topic1.messageresources;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * This simple application demonstrates the Spring feature using which you can
 * retrieve messages from message bundles. Multiple Locales are supported. See {@link #main(String[])}
 * 
 * @author </b></b>
 * 
 */
public class TestMessageResourceBundle {

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(
			"application.xml");

	public static void main(String[] args) {

		Locale locale1 = Locale.getDefault();
		String message1 = ctx.getMessage("welcome", new Object[0], locale1);
		System.out.println(message1);

		Locale locale2 = Locale.FRANCE;
		String message2 = ctx.getMessage("welcome", new Object[0], locale2);
		System.out.println(message2);
	}

}
