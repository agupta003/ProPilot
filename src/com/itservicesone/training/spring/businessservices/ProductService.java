package com.itservicesone.training.spring.businessservices;

import com.itservicesone.training.spring.model.IProductDAO;

public class ProductService {

	private IProductDAO productDAO = null;

	
	
	public ProductService(IProductDAO dao) {
		this.productDAO = dao;

	}

	public IProductDAO getDAO() {
		return this.productDAO;
	}
}
