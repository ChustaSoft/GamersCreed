package gamerscreed.rocketstats.controller;

import org.springframework.web.servlet.ModelAndView;

import gamerscreed.rocketstats.utilities.WebServiceControllerCallDispatcher;

public abstract class BaseController {

	protected WebServiceControllerCallDispatcher callDispatcher;
	
	public BaseController(){
		callDispatcher = new WebServiceControllerCallDispatcher();
	}
	
	public abstract ModelAndView viewIndex();
	
}
