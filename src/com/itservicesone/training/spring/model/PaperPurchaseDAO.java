package com.itservicesone.training.spring.model;

public class PaperPurchaseDAO implements IPaperPurchaseDAO {

	public PaperDescription getDefaultPaperDescription() {
		return defaultPaperDescription;
	}

	public void setDefaultPaperDescription(
			PaperDescription defaultPaperDescription) {
		this.defaultPaperDescription = defaultPaperDescription;
	}

	private PaperDescription defaultPaperDescription;

}
