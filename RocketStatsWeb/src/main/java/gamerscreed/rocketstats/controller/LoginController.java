package gamerscreed.rocketstats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import gamerscreed.rocketstats.beans.LoginPlayerViewBean;
import gamerscreed.rocketstats.components.UserSessionObject;
import gamerscreed.rocketstats.controller.base.BaseController;

@Controller
@SessionAttributes("userSession")
@RequestMapping(value="/login")
public class LoginController extends BaseController{

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewIndex() {
		ModelAndView tmpModel = new ModelAndView("LoginView");
		tmpModel.addObject("loginViewBean", new LoginPlayerViewBean());
		
		return tmpModel;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView executeLogin(@ModelAttribute("loginViewBean") LoginPlayerViewBean aLoginPlayer) {
		//TODO: LLamada via REST
			//DataSender tmpRetrivedResponse = callDispatcher.MakeRequest("localhost:8080/players/login", new DataSender(aPlayer));		
			//PlayerViewBean tmpPlayer = (PlayerViewBean) tmpRetrivedResponse.getDataObject();
		
		UserSessionObject testPlayer = DataTestViewModelGenerator.getTestUserSessionObject();
		
		if(testPlayer != null){
					
			ModelAndView tmpModelAndView = new ModelAndView();
			tmpModelAndView.addObject(SessionConst, testPlayer);
			tmpModelAndView.setViewName("HomeView");
			return tmpModelAndView;
		}
			
		else 
			return viewIndex();			
	}
	
}