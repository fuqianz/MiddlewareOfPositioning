package edu.sse.ustc.restful.resource.helper;

import edu.sse.ustc.database.returnitem.Customers;
import edu.sse.ustc.restful.get.GetCustomer;
import edu.sse.ustc.restful.get.impl.GetCustomerImpl;

public class CustomerHelper {

	private static GetCustomer getCustomer = new GetCustomerImpl();
	
	public static Customers getCustomerInEnvironment(int environmentId,String starttime,String endtime,int months,int requestType)
	{
		return getCustomer.getCustomersInEnvironment(environmentId, starttime, endtime, months, requestType);
	}
	
	public static Customers getCustomerInMap(int environmentId,int mapId,String starttime,String endtime,int months,int requestType)
	{
		return getCustomer.getCustomersInMap(environmentId,mapId, starttime, endtime, months, requestType);
	}
}
