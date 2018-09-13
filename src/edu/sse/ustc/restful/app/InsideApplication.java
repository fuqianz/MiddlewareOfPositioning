package edu.sse.ustc.restful.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import edu.sse.ustc.restful.resource.CurrentSysDateResource;
import edu.sse.ustc.restful.resource.EnvironmentsResources;
import edu.sse.ustc.restful.resource.Resources;
import edu.sse.ustc.restful.resource.StaResources;

/***
 * 
 * @author fqbrighter
 * 
 */
public class InsideApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rrcs = new HashSet<Class<?>>();
		rrcs.add(Resources.class);
		rrcs.add(StaResources.class);
		rrcs.add(EnvironmentsResources.class);
		//rrcs.add(RealTimeResource.class);
		rrcs.add(CurrentSysDateResource.class);
		//rrcs.add(StatisticsQueryResources.class);
		//rrcs.add(HistoryResources.class);
		return rrcs;
	}

}
