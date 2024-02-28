package com.itservicesone.training.spring.businessservices;

import com.itservicesone.training.spring.model.IOrderDAO;

public class OrderService {

	private IOrderDAO orderDAO;

	
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}


}
