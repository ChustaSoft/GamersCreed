package gamerscreed.rocketstats.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import gamerscreed.profiler.model.beans.LoginPlayerViewBean;
import gamerscreed.rocketstats.controller.base.BaseController;
import gamerscreed.rocketstats.model.beans.PlayerViewBean;

@Controller
@RequestMapping(value = "/") 
@SessionAttributes("userSession")
public class HomeController extends BaseController {

	RestTemplate _restTemplate= new RestTemplate();
	
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewIndex(HttpServletRequest aRequest, HttpServletResponse aResponse, HttpSession aSession) 
	{
		ModelAndView tModelAndView = new ModelAndView();
//		if(true)
//		{
			tModelAndView.setViewName("LoginView");
			tModelAndView.addObject("loginViewBean", new LoginPlayerViewBean());			
//		}
//		else
//		{
//			tModelAndView.setViewName("UsersView");
//			tModelAndView.addObject("playerViewBean", new PlayerViewBean());
//			tModelAndView.addObject("playerList", DataTestViewModelGenerator.getTestPlayerArray());			
//		}
		return tModelAndView;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest aRequest, HttpServletResponse aResponse, @ModelAttribute("loginViewBean") LoginPlayerViewBean aLoginPlayer, HttpSession aSession) 
	{
		_restTemplate.postForObject("http://localhost:8081/players/login", new PlayerViewBean(aLoginPlayer.getUserName(), aLoginPlayer.getUserPassword()), String.class);	

		return new UsersController().viewIndex(aRequest, aResponse, aSession);
	}

}
