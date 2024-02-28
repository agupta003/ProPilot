package com.itservicesone.training.spring.businessservices;

import com.itservicesone.training.spring.model.IInvoiceDAO;
import com.itservicesone.training.spring.model.IOrderDAO;

public class InvoiceService {

	private IInvoiceDAO invoiceDAO;

	public InvoiceService(IInvoiceDAO dao) {
		this.invoiceDAO = dao;

	}

	public IInvoiceDAO getInvoiceDAO() {
		return this.invoiceDAO;

	}

}
