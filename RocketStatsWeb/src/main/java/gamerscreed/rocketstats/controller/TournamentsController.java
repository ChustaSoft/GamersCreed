package gamerscreed.rocketstats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import gamerscreed.rocketstats.beans.MatchViewModel;
import gamerscreed.rocketstats.controller.base.BaseController;

@Controller
@SessionAttributes("userSession")
@RequestMapping(value="/tournaments")
public class TournamentsController extends BaseController {
	
	@Override
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewIndex() {
		//TODO : Slider imagenes de juegos del clan
		
		ModelAndView tmpViewModel = new ModelAndView("TournamentsView");
		tmpViewModel.addObject("tournamentViewBean", DataTestViewModelGenerator.getTestTournamentView());		
		return tmpViewModel;
	}

}
