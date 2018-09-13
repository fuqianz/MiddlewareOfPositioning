package edu.sse.ustc.restful.get;

import edu.sse.ustc.database.returnitem.Customers;

public interface GetCustomer {

	public Customers getCustomersInEnvironment(int environmentId, String starttime, String endtime, int months,
			int requestType);

	public Customers getCustomersInMap(int environmentId, int mapId, String starttime, String endtime, int months,
			int requestType);
}
