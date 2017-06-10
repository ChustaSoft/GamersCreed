package gamerscreed.rocketstats.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
	
	public abstract ModelAndView viewIndex(HttpServletRequest aRequest, HttpServletResponse aResponse, HttpSession aSession);
}
