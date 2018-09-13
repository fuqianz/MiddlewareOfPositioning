package edu.sse.ustc.restful.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import edu.sse.ustc.restful.get.GetResources;
import edu.sse.ustc.restful.get.impl.GetResourcesImpl;


@Path("currentsysdatetime")
public class CurrentSysDateResource {

	@GET
	@Produces("application/json")
	public String getCurrentSysDateResource(){
		
		GetResources gr = new GetResourcesImpl();
		
		return  gr.getCurrentSysDateTime();
	}
	
}
