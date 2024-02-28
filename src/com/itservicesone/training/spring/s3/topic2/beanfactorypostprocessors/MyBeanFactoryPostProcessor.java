package com.itservicesone.training.spring.s3.topic2.beanfactorypostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * This processor is executed after all the bean definitions are loaded but
 * before they are instantiated
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {

		System.out
				.println("BeanFactory has loaded the definitions of bean but yet not initialized any bean : "
						+ beanFactory.getBeanDefinitionCount());

	}

}
