package gamerscreed.rocketstats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gamerscreed.profiler.structures.DataSender;
import gamerscreed.rocketstats.beans.PlayerViewBean;

@Controller
public class LoginController extends BaseController{

	@Override
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView viewIndex() {
		ModelAndView tmpModel = new ModelAndView("LoginView");
		PlayerViewBean tmpPlayer = new PlayerViewBean();
		tmpModel.addObject("playerBean", tmpPlayer);
		
		return tmpModel;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(@ModelAttribute("playerDto") PlayerViewBean aPlayer) {
		DataSender tmpRetrivedResponse = callDispatcher.MakeRequest("localhost:8080/players/login", new DataSender(aPlayer));
						
		PlayerViewBean player = (PlayerViewBean) tmpRetrivedResponse.getDataObject();
		
			if(player != null)
				return new ModelAndView("HomeView");
			else 
				return viewIndex();			
	}
	
}