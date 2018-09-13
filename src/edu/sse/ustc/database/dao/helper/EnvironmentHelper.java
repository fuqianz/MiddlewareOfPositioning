package edu.sse.ustc.database.dao.helper;

import java.util.List;

import edu.sse.ustc.database.dao.EnvironmentDao;
import edu.sse.ustc.innerclass.Environment;
public class EnvironmentHelper {
	private static EnvironmentDao getEnvironment = new EnvironmentDao();
	
	public static List<Environment> getEnvironment(){
		return getEnvironment.getEnvironment();
	}
	
	public static List<Integer> getEnviromentId(){
		return getEnvironment.getEnviromentId();
	}
	
	public static Environment getEnvironmentById(int environmentId){
		return getEnvironment.getEnvironmentById(environmentId);
	}
	
	public static boolean newEnvironment(List<Environment> ems){
		return getEnvironment.newEnvironment(ems);
	}
	
	public static void updateEnvironment(int environmentId, String name){
		getEnvironment.updateEnvironment(environmentId, name);
	}
	
	public static void delEnvironment(int environmentId){
		getEnvironment.delEnvironment(environmentId);
	}
}
