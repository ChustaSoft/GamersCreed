package gamerscreed.rocketstats.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		ModelAndView tViewModel = new ModelAndView("TournamentsView");
		tViewModel.addObject("tournamentViewBean", DataTestViewModelGenerator.getTestTournamentView());		
		return tViewModel;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody MatchViewModel getMatchModelFromGivenId(@RequestParam("matchId") int aMatchId){
		return DataTestViewModelGenerator.getTestTournamentView().getUndoneMatchViewModelList().get(aMatchId);		
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView updateMatch(@RequestBody MatchViewModel aMatchViewModel){
				
		//TODO: Update match
		
		return viewIndex();
	}

}
