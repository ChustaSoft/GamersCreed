package gamerscreed.rocketstats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import gamerscreed.rocketstats.controller.base.BaseController;

@Controller
@SessionAttributes("userSession")
public class HomeController extends BaseController
{
	
	@Override
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView viewIndex() {
		//TODO : Slider imagenes de juegos del clan
		return new ModelAndView("HomeView");
	}	
	
}
