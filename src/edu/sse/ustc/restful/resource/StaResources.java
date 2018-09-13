package edu.sse.ustc.restful.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;

import edu.sse.ustc.database.returnitem.StasPath;
import edu.sse.ustc.database.returnitem.StasPos;
import edu.sse.ustc.restful.resource.helper.HistoryResourcesHelper;
import edu.sse.ustc.restful.resource.helper.ParameterControl;

@Path("sta")
public class StaResources
{
    @GET
    @Path("{sta_mac}/history/pos")
    @Produces("application/json")
    public StasPos getTagLocContractAtTimeJson(@PathParam("sta_mac") String apMac, @QueryParam("time") String Stringtime)
    {
        apMac = ParameterControl.getMac(apMac);
        if (apMac == null || ParameterControl.timeInputError(Stringtime))
        {
            return new StasPos();
        }

        return HistoryResourcesHelper.getTagLocContractAtTime(apMac, Stringtime);
    }

    @GET
    @Path("{sta_mac}/history/path")
    @Produces("application/json")
    public StasPath getTagPathContractAtTimeJson(@PathParam("sta_mac") String apMac, @QueryParam("start_time") String starttime,
            @QueryParam("end_time") String endtime)
    {
        apMac = ParameterControl.getMac(apMac);
        if (apMac == null || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new StasPath();
        }
        return HistoryResourcesHelper.getTagPathContractAtTime(apMac, starttime, endtime);
    }
}
