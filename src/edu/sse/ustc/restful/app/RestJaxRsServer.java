package edu.sse.ustc.restful.app;


import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.ext.jaxrs.JaxRsApplication;

import edu.sse.ustc.common.MyLog;

/***
 * 
 * @author fqbrighter
 */
public class RestJaxRsServer{
	public static void run(){
     try{	
		Component component = new Component(); 
        component.getServers().add(Protocol.HTTP,8085);         
        component.getDefaultHost().attach(new RestJaxRsApplication(null)); 
        component.start();  
	   }
	  catch(Exception e)
	  {
		 // e.printStackTrace();
		  MyLog.error(e.toString(), "edu.sse.ustc.restfl.app.RestJaxRsServer");
	  }
	} 

	// public static void main(String[] args) throws Exception {
	//
	// RestJaxRsServer rjrs = new RestJaxRsServer();
	// rjrs.run();
	// // Thread tt = new Thread(rjrs);
	// // tt.start();
	// // tt.join();
	// // Component component = new Component();
	// // component.getServers().add(Protocol.HTTP, 8085);
	// // component.getDefaultHost().attach(new RestJaxRsApplication(null));
	// // component.start();
	// }

}
