package com.itservicesone.training.spring.s1.topic2.simpleaop;

/**
 * This is the interface that is realized by the class that is the target of
 * Advice. It is this interface that will be proxied by ProxyFactoryBean.
 * Proxy is a very simple design pattern where a class (proxy) behaves like the
 * real subject. Clients make call to the proxy and proxy in turn will make
 * calls to the real subject. However, in the process, proxy adds some
 * behavior before or after making the call to the real subject.
 * @see <a href="http://www.muhammedshakir.com/web/guest/blogsdisplay/-/blogs/proxy-gof-design-pattern?_33_redirect=/web/guest/blogs" target="_blank">Proxy Design Pattern</a>
 * @author <b>Muhammed Shakir</b>
 */
public interface TheTargetInterface {

	public void doSomething();
	
	public void doSomethingElse();

}
