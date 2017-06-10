package gamerscreed.rocketstats.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import gamerscreed.rocketstats.controller.base.BaseController;
import gamerscreed.rocketstats.model.beans.MatchViewModel;


@Controller
@SessionAttributes("userSession")
@RequestMapping(value="/tournaments")
public class TournamentsController extends BaseController {
	
	@Override
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewIndex(HttpServletRequest aRequest, HttpServletResponse aResponse, HttpSession aSession) 
	{
		ModelAndView tViewModel = new ModelAndView("TournamentsView");
	
		tViewModel.addObject("tournamentViewBean", DataTestViewModelGenerator.getTestTournamentView());
		return tViewModel;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public MatchViewModel getMatchModelFromGivenId(@RequestParam("matchId") int aMatchId)
	{
		return DataTestViewModelGenerator.getTestTournamentView().getUndoneMatchViewModelList().get(aMatchId);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView updateMatch(@RequestBody MatchViewModel aMatchViewModel)
	{				
		//TODO: Update match
		
		return viewIndex(null, null, null);
	}

}
