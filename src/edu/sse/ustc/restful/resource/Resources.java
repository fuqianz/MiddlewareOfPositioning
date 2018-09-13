package edu.sse.ustc.restful.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.Post;

import edu.sse.ustc.database.common.AcrossMap;
import edu.sse.ustc.database.common.SpaceType;
import edu.sse.ustc.database.common.StayDur;
import edu.sse.ustc.database.common.StayInfo;
import edu.sse.ustc.database.common.TagEnterTimes;
import edu.sse.ustc.database.common.TagLeaveTimes;
import edu.sse.ustc.database.returnitem.Customers;
import edu.sse.ustc.database.returnitem.DayMac;
import edu.sse.ustc.database.returnitem.Heatmap;
import edu.sse.ustc.database.returnitem.Stas;
import edu.sse.ustc.database.returnitem.StasPath;
import edu.sse.ustc.database.returnitem.StasPos;
import edu.sse.ustc.database.returnitem.VisitedTimes;
import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.myenum.DevStatus;
import edu.sse.ustc.restful.resource.helper.CustomerHelper;
import edu.sse.ustc.restful.resource.helper.HeatMapHelper;
import edu.sse.ustc.restful.resource.helper.HistoryResourcesHelper;
import edu.sse.ustc.restful.resource.helper.ParameterControl;
import edu.sse.ustc.restful.resource.helper.RealTimeResourceHelper;
import edu.sse.ustc.restful.resource.helper.ResourceHelper;
import edu.sse.ustc.restful.resource.helper.StatisticsQueryResourcesHelper;
import edu.sse.ustc.restful.resource.helper.VisitedStatsHelper;

@Path("environment")
public class Resources
{

    private Logger log = Logger.getLogger(this.getClass());

    @GET
    @Path("{environmentid}")
    @Produces("application/json")
    public JSONObject getEnvironmentName(@PathParam("environmentid") int environmentid) throws JSONException
    {
        if (ParameterControl.intInputError(environmentid))
        {
        	JSONObject json = new JSONObject();
        	json.append("Code", -1);
        	json.append("msg", "Error Parameters");
            return json;
        }

        return new JSONObject(ResourceHelper.getEnvironment(environmentid));
    }
//    @GET
//    @Path("{environmentid}")
//    @Produces("application/json")
//    public Environment getEnvironmentNameJson(@PathParam("environmentid") int environmentid)
//    {
//        if (ParameterControl.intInputError(environmentid))
//        {
//            return new Environment();
//        }
//
//        return ResourceHelper.getEnvironment(environmentid);
//    }

    @GET
    @Path("{environmentid}/maps")
    @Produces("application/json")
    public List<Map> getAllMapsEnvironmentJson(@PathParam("environmentid") int environmentid)
    {
        if (ParameterControl.intInputError(environmentid))
        {
            return new ArrayList<Map>();
        }

        return ResourceHelper.getAllMapsAtEnvironment(environmentid);
    }

    @Post
    @Path("{environmentid}")
    @Produces("application/json")
    public Environment turnOnPushServiceEnvironmentJson(@PathParam("environmentid") int environmentid,@QueryParam("push") String push,@QueryParam("pushdestip") String ip,@QueryParam("pushdestport") int port)
    {
        return null; // ResourceHelper.getEnvironment(environmentid);
    }

    @Post
    @Path("{environmentid}")
    @Produces("application/json")
    public Environment turnOffPushServiceEnvironmentJson(@PathParam("environmentid") int environmentid)
    {
        return null;// ResourceHelper.getEnvironment(environmentid);
    }

    @GET
    @Path("{environmentid}/map/{mapid}")
    @Produces("application/json")
    public Map getEnvironmentMapsJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid)
    {
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid))
        {
            return new Map();
        }

        return ResourceHelper.getEnvironmentMap(environmentid, mapid);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/{image_file_name}")
    @Produces("image/*")
    public Response getMapImage(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @PathParam("image_file_name") String imageFileName)
    {
        // File directory = new File("");
        // try{
        // System.out.println(directory.getCanonicalPath());
        // System.out.println(directory.getAbsolutePath());
        // }catch(Exception e){}
        Map mc = this.getEnvironmentMapsJson(environmentid, mapid);

        if (mc.getMapId() == null || !imageFileName.equals(mc.getMapImageName()))
        {
            log.error(imageFileName + "Not Exist");
            return Response.ok("file not exist").build();
        }

        File file = new File(".//map_image//" + imageFileName + "." + mc.getMapFormat().toString());

          
        String mt = new MimetypesFileTypeMap().getContentType(file);
        
        System.out.println(mt); 
        
        return Response.ok(file, mt).build();
    }

    @GET
    @Path("{environmentid}/map/{mapid}/aps")
    @Produces("application/json")
    public List<AP> getAPContractJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid)
    {
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid))
        {
            return new ArrayList<AP>();
        }

        return ResourceHelper.getAP(environmentid, mapid);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/ap/{ap_mac}")
    @Produces("application/json")
    public AP getAPContractJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @PathParam("ap_mac") String ap_Mac)
    {
        String apMac = ParameterControl.getMac(ap_Mac);

        if (apMac == null || ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid))
        {
            return new AP();
        }

        return ResourceHelper.getAPContract(environmentid, mapid, apMac);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/ap/{ap_mac}/status")
    @Produces("application/json")
    public DevStatus getAPStatusJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid, @PathParam("ap_mac") String ap_Mac)
    {
        String apMac = ParameterControl.getMac(ap_Mac);

        if (apMac == null || ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid))
        {
            return null;
        }

        return ResourceHelper.getAPStatus(environmentid, mapid, apMac);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/enteredstas/list")
    @Produces("application/json")
    public List<Stas> getAllTagContractAtTimeAndMapSpaceJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("type") int type1, @QueryParam("r1") double r1, @QueryParam("r2") double r2, @QueryParam("r3") double r3,
            @QueryParam("r4") double r4, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;

        if (ParameterControl.spaceTypeInputError(type1) || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new ArrayList<Stas>();
        }

        type.setValue(type1);

        return StatisticsQueryResourcesHelper.getAllTagContractAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/enteredstas/count")
    @Produces("application/json")
    public int getNumberAllTagContractAtTimeAndMapSpaceJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("type") int type1, @QueryParam("r1") double r1, @QueryParam("r2") double r2, @QueryParam("r3") double r3,
            @QueryParam("r4") double r4, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;

        if (ParameterControl.spaceTypeInputError(type1) || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return -1;
        }

        type.setValue(type1);
        return StatisticsQueryResourcesHelper
                .getNumberAllTagContractAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/leavedstas/list")
    @Produces("application/json")
    public List<Stas> getAllLeaveTagContractAtTimeAndMapSpaceJson(@PathParam("environmentid") int environmentid,
            @PathParam("mapid") int mapid, @QueryParam("type") int type1, @QueryParam("r1") double r1, @QueryParam("r2") double r2,
            @QueryParam("r3") double r3, @QueryParam("r4") double r4, @QueryParam("start_time") String starttime,
            @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;

        if (ParameterControl.spaceTypeInputError(type1) || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new ArrayList<Stas>();
        }

        type.setValue(type1);

        return StatisticsQueryResourcesHelper.getAllLeaveTagContractAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/leavedstas/count")
    @Produces("application/json")
    public int getNumberOfLeaveTagContractAtTimeAndMapSpaceJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("type") int type1, @QueryParam("r1") double r1, @QueryParam("r2") double r2, @QueryParam("r3") double r3,
            @QueryParam("r4") double r4, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;

        if (ParameterControl.spaceTypeInputError(type1) || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return -1;
        }

        type.setValue(type1);

        return StatisticsQueryResourcesHelper.getNumberOfLeaveTagContractAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime,
                endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/entertimes/list")
    @Produces("application/json")
    public List<TagEnterTimes> getTagEnterTimesAtTimeAndMapSpaceJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("type") int type1, @QueryParam("r1") double r1, @QueryParam("r2") double r2, @QueryParam("r3") double r3,
            @QueryParam("r4") double r4, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;

        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid) || ParameterControl.spaceTypeInputError(type1)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new ArrayList<TagEnterTimes>();
        }

        type.setValue(type1);

        return StatisticsQueryResourcesHelper.getTagEnterTimesAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/entertimes/count")
    @Produces("application/json")
    public int getNumberOfTimesTagAtTimeAndMapSpaceJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("type") int type1, @QueryParam("r1") double r1, @QueryParam("r2") double r2, @QueryParam("r3") double r3,
            @QueryParam("r4") double r4, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid) || ParameterControl.spaceTypeInputError(type1)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return -1;
        }
        type.setValue(type1);

        return StatisticsQueryResourcesHelper.getNumberOfTimesTagAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/leavetimes/list")
    @Produces("application/json")
    public List<TagLeaveTimes> getTagLeaveTimesAtTimeAndMapSpaceJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("type") int type1, @QueryParam("r1") double r1, @QueryParam("r2") double r2, @QueryParam("r3") double r3,
            @QueryParam("r4") double r4, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;

        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid) || ParameterControl.spaceTypeInputError(type1)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new ArrayList<TagLeaveTimes>();
        }

        type.setValue(type1);

        return StatisticsQueryResourcesHelper.getTagLeaveTimesAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/leavetimes/count")
    @Produces("application/json")
    public int getNumberOfTagLeaveTimesAtTimeAndMapSpaceJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("type") int type1, @QueryParam("r1") double r1, @QueryParam("r2") double r2, @QueryParam("r3") double r3,
            @QueryParam("r4") double r4, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;

        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid) || ParameterControl.spaceTypeInputError(type1)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return -1;
        }

        type.setValue(type1);

        return StatisticsQueryResourcesHelper.getNumberOfTagLeaveTimesAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime,
                endtime);
    }

    @GET
    @Path("{environmentid}/statics/fromtotimes/list")
    @Produces("application/json")
    public List<AcrossMap> getTagInfoAcrossTwoMapsAtTimesJson(@PathParam("environmentid") int environmentid, @QueryParam("mapid1") int mapid1,
            @QueryParam("mapid2") int mapid2, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        System.out.println(starttime + " " + endtime);
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid1) || ParameterControl.intInputError(mapid2)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new ArrayList<AcrossMap>();
        }

        return StatisticsQueryResourcesHelper.getTagInfoAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/statics/fromtotimes/count")
    @Produces("application/json")
    public int getNumbersOfTagAcrossTwoMapsAtTimesJson(@PathParam("environmentid") int environmentid, @QueryParam("mapid1") int mapid1,
            @QueryParam("mapid2") int mapid2, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid1) || ParameterControl.intInputError(mapid2)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return -1;
        }
        return StatisticsQueryResourcesHelper.getNumbersOfTagAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/statics/fromtostas/list")
    @Produces("application/json")
    public List<AcrossMap> getAllTagInfoAcrossTwoMapsAtTimesJson(@PathParam("environmentid") int environmentid, @QueryParam("mapid1") int mapid1,
            @QueryParam("mapid2") int mapid2, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid1) || ParameterControl.intInputError(mapid2)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new ArrayList<AcrossMap>();
        }

        return StatisticsQueryResourcesHelper.getAllTagInfoAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/statics/fromtostas/count")
    @Produces("application/json")
    public int getNumbersOfAllTagAcrossTwoMapsAtTimesJson(@PathParam("environmentid") int environmentid, @QueryParam("mapid1") int mapid1,
            @QueryParam("mapid2") int mapid2, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid1) || ParameterControl.intInputError(mapid2)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return -1;
        }
        return StatisticsQueryResourcesHelper.getNumbersOfAllTagAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/statics/stayinfo")
    @Produces("application/json")
    public StayInfo getStayInfoOfAllTagJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("type") int typeValue, @QueryParam("r1") double r1, @QueryParam("r2") double r2, @QueryParam("r3") double r3,
            @QueryParam("r4") double r4, @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;

        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid) || ParameterControl.spaceTypeInputError(typeValue)
                || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new StayInfo();
        }

        type.setValue(typeValue);

        return StatisticsQueryResourcesHelper.getStayInfoOfAllTag(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/{sta_mac}/statics/stayduration")
    @Produces("application/json")
    public StayDur getTagStayDurInMapJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @PathParam("sta_mac") String ap_Mac, @QueryParam("type") int typeValue, @QueryParam("r1") double r1, @QueryParam("r2") double r2,
            @QueryParam("r3") double r3, @QueryParam("r4") double r4, @QueryParam("start_time") String starttime,
            @QueryParam("end_time") String endtime)
    {
        SpaceType type = SpaceType.CurrentSpace;
        String apMac = ParameterControl.getMac(ap_Mac);

        if (apMac == null || ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid)
                || ParameterControl.spaceTypeInputError(typeValue) || ParameterControl.timeInputError(starttime)
                || ParameterControl.timeInputError(endtime))
        {
            return new StayDur();
        }
        type.setValue(typeValue);

        return StatisticsQueryResourcesHelper.getTagStayDurInMap(environmentid, mapid, apMac, type, r1, r2, r3, r4, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/history/staspos")
    @Produces("application/json")
    public List<StasPos> getTagPosAtTimeJson(@PathParam("environmentid") int environmentid, @QueryParam("time") String Stringtime)
    {
        if (ParameterControl.intInputError(environmentid) || ParameterControl.timeInputError(Stringtime))
        {
            return new ArrayList<StasPos>();
        }
        return HistoryResourcesHelper.getTagPosAtTime(environmentid, Stringtime);
    }

    @GET
    @Path("{environmentid}/history/staspath")
    @Produces("application/json")
    public List<StasPath> getTagPathAtTimeJson(@PathParam("environmentid") int environmentid, @QueryParam("start_time") String starttime,
            @QueryParam("end_time") String endtime)
    {
        if (ParameterControl.intInputError(environmentid) || ParameterControl.timeInputError(starttime) || ParameterControl.timeInputError(endtime))
        {
            return new ArrayList<StasPath>();
        }
        return HistoryResourcesHelper.getTagPathTimes(environmentid, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/history/staspos")
    @Produces("application/json")
    public List<StasPos> getTagPosAtTimeAndMapJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("time") String Stringtime)
    {
        if (ParameterControl.timeInputError(Stringtime) || ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid))
        {
            return new ArrayList<StasPos>();
        }
        return HistoryResourcesHelper.getTagPosAtTimeAndMap(environmentid, mapid, Stringtime);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/history/staspath")
    @Produces("application/json")
    public List<StasPath> getAllTagPosAtTimeAndMapJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime)
    {
    	
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid) || ParameterControl.timeInputError(starttime)
                || ParameterControl.timeInputError(endtime))
        {
            return new ArrayList<StasPath>();
        }
        return HistoryResourcesHelper.getAllTagPosAtTimeAndMap(environmentid, mapid, starttime, endtime);
    }

    @GET
    @Path("{environmentid}/current/stas")
    @Produces("application/json")
    public List<Stas> getAllTagScannedJson(@PathParam("environmentid") int environmentid)
    {
        if (ParameterControl.intInputError(environmentid))
        {
            return new ArrayList<Stas>();
        }
        return RealTimeResourceHelper.getAllTagScanned(environmentid);
    }

    @GET
    @Path("{environmentid}/current/stas/pos")
    @Produces("application/json")
    public List<StasPos> getAllTagScannedPosJson(@PathParam("environmentid") int environmentid)
    {
        if (ParameterControl.intInputError(environmentid))
        {
            return new ArrayList<StasPos>();
        }
        return RealTimeResourceHelper.getAllTagScannedPos(environmentid);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/current/stas/pos")
    @Produces("application/json")
    public List<StasPos> getAllTagScannedInMapPosJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid)
    {
        if (ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid))
        {
            return new ArrayList<StasPos>();
        }
        return RealTimeResourceHelper.getAllTagScannedInMapPos(environmentid, mapid);
    }

    @GET
    @Path("{environmentid}/map/{mapid}/current/sta/{sta_mac}/pos")
    @Produces("application/json")
    public StasPos getTagScannedInMapPosJson(@PathParam("environmentid") int environmentid, @PathParam("mapid") int mapid,
            @PathParam("sta_mac") String apMac)
    {
        apMac = ParameterControl.getMac(apMac);
        if (apMac == null || ParameterControl.intInputError(environmentid) || ParameterControl.intInputError(mapid))
        {
            return new StasPos();
        }
        return RealTimeResourceHelper.getTagScannedInMapPos(environmentid, mapid, apMac);
    }
    

	@GET
	@Path("{environmentid}/statics/newoldcustomer")
	@Produces("application/json")
	public Customers getCustomerInEnvironment(@PathParam("environmentid") int environmentid,
			@QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime,
			@QueryParam("validmonths") int months, @QueryParam("request_type") int requestType) {

		return CustomerHelper.getCustomerInEnvironment(environmentid, starttime, endtime, months, requestType);
	}

	@GET
	@Path("{environmentid}/map/{mapId}/statics/newoldcustomer")
	@Produces("application/json")
	public Customers getCustomerInMap(@PathParam("environmentid") int environmentid, @PathParam("mapId") int mapId,
			@QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime,
			@QueryParam("validmonths") int months, @QueryParam("request_type") int requestType) {

		return CustomerHelper.getCustomerInMap(environmentid, mapId, starttime, endtime, months, requestType);
	}
	
	@GET
	@Path("{environmentid}/map/{mapId}/statics/heatmap")
	@Produces("application/json")
	public List<Heatmap> getHeatMap(@PathParam("environmentid") int environmentid, @PathParam("mapId") int mapId,
			@QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime){
		return HeatMapHelper.getHeatMap(environmentid, mapId, starttime, endtime);
	}
	
	@GET
	@Path("{environment_id}/statics/visitedtimes")
	@Produces("application/json")
	public VisitedTimes getVisitedTimesInEnvironment(@PathParam("environment_id") int environmentId,
			@QueryParam("start_time") String starttime, @QueryParam("end_time") String endtime) {
		return VisitedStatsHelper.getVisitedTimesInEnvironment(environmentId, starttime, endtime);

	}

	@GET
	@Path("{environment_id}/map/{map_id}/statics/visitedtimes")
	@Produces("application/json")
	public VisitedTimes getVisitedTimesInMap(@PathParam("environment_id") int environmentId,
			@PathParam("map_id") int mapId, @QueryParam("start_time") String starttime,
			@QueryParam("end_time") String endtime) {
		return VisitedStatsHelper.getVisitedTimesInMap(environmentId, mapId, starttime, endtime);

	}
	
	@GET
	@Path("{environment_id}/map/{map_id}/statics/visitedcount")
	@Produces("application/json")
	public List<DayMac> getCountInMap(@PathParam("environment_id") int environmentId,
			@PathParam("map_id") int mapId,@QueryParam("type") int typeValue, @QueryParam("r1") double r1, @QueryParam("r2") double r2,
            @QueryParam("r3") double r3, @QueryParam("r4") double r4, @QueryParam("start_time") String starttime,
			@QueryParam("end_time") String endtime) {
		return VisitedStatsHelper.getDayMacCount(environmentId, mapId, typeValue, r1, r2, r3, r4, starttime, endtime);

	}

}
