package edu.sse.ustc.restful.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.restful.resource.helper.ResourceHelper;

@Path("environments")
public class EnvironmentsResources
{
    @GET
    @Produces("application/json")
    public List<Environment> getAllEnvironmentJson()
    {
        return ResourceHelper.getAllEnvironment();
    }

}
