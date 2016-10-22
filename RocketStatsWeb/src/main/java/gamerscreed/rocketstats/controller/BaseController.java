package gamerscreed.rocketstats.controller;

import gamerscreed.profiler.structures.SecurityInfo;
import gamerscreed.rocketstats.utilities.WebServiceControllerCallDispatcher;

public abstract class BaseController {

	WebServiceControllerCallDispatcher callDispatcher;
	
	public BaseController(){
		callDispatcher = new WebServiceControllerCallDispatcher();
	}
	
	public abstract String viewIndex(SecurityInfo aSecurityInfo);
	
}
