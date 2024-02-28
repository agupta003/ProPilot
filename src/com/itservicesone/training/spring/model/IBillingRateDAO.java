package com.itservicesone.training.spring.model;

import java.util.List;

public interface IBillingRateDAO {

	public void updateRate();

	public BillingRate getBillingRate(final Integer billingRateId);

	public List getAllBillingRates();

	public void reviseBillingRates(final List<BillingRate> rates);
	
	public int getTotalDefinedBillingRates();
	
	public int getRate(final int rateId);

}
