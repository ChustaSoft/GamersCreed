package gamerscreed.rocketstats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gamerscreed.profiler.structures.SecurityInfo;

@Controller
public class HomeController extends BaseController
{
	
	@Override
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String viewIndex(SecurityInfo aSecurityInfo) {
		// TODO Auto-generated method stub
		return "home";
	}
}
