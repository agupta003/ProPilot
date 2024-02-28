package com.itservicesone.training.spring.s9.topic1.enterpriseservices;

import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Declare a bean with id=mailSender and class={@link JavaMailSenderImpl}. Set
 * the properties like host to value="yoursmtpserver.com" etc You can also have
 * a bean declared with id="mailSession" and class={@link JndiObjectFactoryBean}
 * and property with name="jndiName" and value="java:comp/env/mail/Session". The
 * mailSender can refer to this bean using session property. You can then create
 * an instance of {@link SimpleMailMessage} and use mailSender bean to send
 * mails
 * 
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class TestEmailSender {

}
