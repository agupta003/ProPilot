package com.itservicesone.training.spring.s5.topic1.springaop;

public class MySecurityService implements ISecurityService {

	public void validate() throws ApplicationException2 {

		if (true) {
			throw new ApplicationException2("User is invalid");
		}

	}

}
