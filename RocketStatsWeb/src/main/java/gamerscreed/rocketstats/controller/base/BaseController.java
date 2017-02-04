package gamerscreed.rocketstats.controller.base;

import org.springframework.web.servlet.ModelAndView;

import gamerscreed.rocketstats.utilities.WebServiceControllerCallDispatcher;

public abstract class BaseController {

	protected WebServiceControllerCallDispatcher callDispatcher;
	
	protected final String SessionConst = "userSession";
	
	public BaseController(){
		callDispatcher = new WebServiceControllerCallDispatcher();
	}
	
	public abstract ModelAndView viewIndex();	
}
