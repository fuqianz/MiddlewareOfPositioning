package edu.sse.ustc.restful.app;

import org.restlet.Context;
import org.restlet.ext.jaxrs.JaxRsApplication;

/***
 * 
 * @author Steven http://www.lifeba.org
 */

public class RestJaxRsApplication extends JaxRsApplication {

	public RestJaxRsApplication(Context context) {
		super(context);
		this.add(new InsideApplication());
	}

}
