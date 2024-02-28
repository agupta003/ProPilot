package com.itservicesone.training.spring.s3.topic1.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * This bean participates in the life cycle of the Bean. The methods here are
 * executed during the bean initializaion process.
 * <p>
 * These methods give you two opportunities to alter a bean <b>after it has been
 * created and wired.</b>
 * </p>
 * <p>
 * {@link #postProcessBeforeInitialization(Object, String)} Executes after
 * initialization of properties and before afterPropertiesSet and init-method.
 * The life cycle:
 * <ol>
 * <li>Instantiate</li>
 * <li>Populate Properties</li>
 * <li>BeanNameAware's setBeanName (implement BeanNameAware)</li>
 * <li>BeanFactoryAware's setBeanFactory (implement BeanFactoryAware, ApplicationContextAware)</li>
 * <li><b>Pre-Initialization BeanPostProcessor</b></li>
 * <li>InitializingBean's afterSetProperties</li>
 * <li>Call custom init-method</li>
 * <li>Post-Initialization BeanPostProcessor</li>
 * <li>---- Bean is ready to Use</li>
 * <li>DisposableBeans's destroy</li>
 * <li>Call custom destroy-method</li>
 * </ol>
 * </p>
 * 
 * 
 * <p>
 * {@link #postProcessAfterInitialization(Object, String)} Executes after
 * initialization of properties and <b>before afterPropertiesSet and init-method</b>
 * The life cycle:
 * <ol>
 * <li>Instantiate</li>
 * <li>Populate Properties</li>
 * <li>BeanNameAware's setBeanName (implement BeanNameAware)</li>
 * <li>BeanFactoryAware's setBeanFactory (implement BeanFactoryAware, ApplicationContextAware)</li>
 * <li>Pre-Initialization BeanPostProcessor</li>
 * <li>InitializingBean's afterSetProperties</li>
 * <li>Call custom init-method</li>
 * <li><b>Post-Initialization BeanPostProcessor</b></li>
 * <li>---- Bean is ready to Use</li>
 * <li>DisposableBeans's destroy</li>
 * <li>Call custom destroy-method</li>
 * </ol>
 * </p>
 * This method can be used to alter the state of the bean. For e.g. you can
 * alter all the String variables of all beans to specific value (Fuddify)
 * 
 * @author <b>Muhammed Shakir</b>
 * 
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub

		// System.out.println(bean.getClass().getName() + " -- " + beanName);

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		// System.out.println(bean.getClass().getName() + " -- " + beanName);

		return bean;
	}

}
