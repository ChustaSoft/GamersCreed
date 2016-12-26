package gamerscreed.rocketstats.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gamerscreed.rocketstats.beans.PlayerViewBean;
import gamerscreed.rocketstats.controller.base.BaseController;

@Controller
@RequestMapping(value="/users")
public class UsersController extends BaseController {

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewIndex() {
		//TODO : Llamada via REST service
		
		ModelAndView tmpModelAndView = new ModelAndView("UsersView");
		tmpModelAndView.addObject("playerViewBean", new PlayerViewBean());
		tmpModelAndView.addObject("playerList", DataTestViewModelGenerator.getTestPlayerArray());
		
		return tmpModelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addNewPlayer(@ModelAttribute("playerViewBean") PlayerViewBean aPlayerViewBean){
		//TODO Obtener el usuario, enviarlo via rest, y en caso afirmativo, añadirlo al array de la vista
		List<PlayerViewBean> testList = DataTestViewModelGenerator.getTestPlayerArray();
		testList.add(aPlayerViewBean);
		//
		return new ModelAndView("UsersView", "playerList", testList);
	}
		


}
