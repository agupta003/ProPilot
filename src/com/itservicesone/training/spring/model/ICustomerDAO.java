package com.itservicesone.training.spring.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface ICustomerDAO {

	public void create();

	public List getCustomerTypes();

	public Map getCustomerTypesMap();

	public Properties getCustomerTypesProps();
}
