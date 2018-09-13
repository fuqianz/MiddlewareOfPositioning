package edu.sse.ustc.restful.get.impl;

import edu.sse.ustc.database.returnitem.Customers;
import edu.sse.ustc.database.stats.CustomerStats;
import edu.sse.ustc.restful.get.GetCustomer;

public class GetCustomerImpl implements GetCustomer {

	private static CustomerStats getCustomer = new CustomerStats();
	@Override
	public Customers getCustomersInEnvironment(int environmentId,
			String starttime, String endtime,int months, int requestType) {
		// TODO Auto-generated method stub
		return getCustomer.getCustomersInEnvironment(environmentId, starttime, endtime, months, requestType);
	}
	@Override
	public Customers getCustomersInMap(int environmentId, int mapId,
			String starttime, String endtime, int months, int requestType) {
		// TODO Auto-generated method stub
		return getCustomer.getCustomersInMap(environmentId, mapId, starttime, endtime, months, requestType);
	}

}
