package edu.sse.ustc.restful.get.impl;

import java.util.List;

import edu.sse.ustc.database.dao.helper.ApContentHelper;
import edu.sse.ustc.database.dao.helper.EnvironmentHelper;
import edu.sse.ustc.database.dao.helper.MapHelper;
import edu.sse.ustc.getlocinfo.operation.BasicInfo;
import edu.sse.ustc.getlocinfo.operation.ConnectOperation;
import edu.sse.ustc.getlocinfo.operation.impl.BasicInfoImpl;
import edu.sse.ustc.getlocinfo.operation.impl.ConnectOperationImpl;
import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.myenum.DevStatus;
import edu.sse.ustc.restful.get.GetResources;

public class GetResourcesImpl implements GetResources {
	@Override
	public Environment getEnvironmentById(int environmentid) {
		// TODO Auto-generated method stub
		return EnvironmentHelper.getEnvironmentById(environmentid);
	}

	@Override
	public Map getEnvironmentMap(int environmentid, int mapid) {
		// TODO Auto-generated method stub
		return MapHelper.getMapByMapId(environmentid, mapid);
	}

	@Override
	public String getCurrentSysDateTime() {
		
		ConnectOperation co = new ConnectOperationImpl();
		BasicInfo bi = new BasicInfoImpl();
		return bi.getServerTime(co).toString();
	}

	@Override
	public List<AP> getAp(int environmentid, int mapid) {
		// TODO Auto-generated method stub
		List<AP> aps = ApContentHelper.getAp(environmentid, mapid);
		return aps;
	}

	@Override
	public AP getApContract(int environmentid, int mapid, String apMac) {
		// TODO Auto-generated method stub
		AP ap = ApContentHelper.getApByApMac(environmentid, mapid, apMac);

		return ap;
	}

	@Override
	public DevStatus getAPStatus(int environmentid, int mapid, String apMac) {
		// TODO Auto-generated method stub
		AP ap = ApContentHelper.getApByApMac(environmentid, mapid, apMac);
		if (ap == null)
			return null;
		return ap.getStatus();

	}

	@Override
	public List<Environment> getAllEnvironment() {
		// TODO Auto-generated method stub
		return EnvironmentHelper.getEnvironment();
	}

	@Override
	public List<Map> getAllMapsAtEnvironment(int environmentid) {
		return MapHelper.getMap(environmentid);
	}
}
