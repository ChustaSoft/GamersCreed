package gamerscreed.rocketstats.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import gamerscreed.rocketstats.controller.base.BaseController;
import gamerscreed.rocketstats.model.beans.PlayerViewBean;


@Controller
@SessionAttributes("userSession")
@RequestMapping(value="/users")
public class UsersController extends BaseController {

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewIndex(HttpServletRequest aRequest, HttpServletResponse aResponse, HttpSession aSession)
	{
		ModelAndView tmpModelAndView = new ModelAndView("UsersView");
		tmpModelAndView.addObject("playerViewBean", new PlayerViewBean());
		tmpModelAndView.addObject("playerList", DataTestViewModelGenerator.getTestPlayerArray());
		//TODO add object for security
		//Test
		Enumeration<String> e = aSession.getAttributeNames();
		//
		
		return tmpModelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addNewPlayer(@ModelAttribute("playerViewBean") PlayerViewBean aPlayerViewBean)
	{
		//TODO Obtener el usuario, enviarlo via rest, y en caso afirmativo, añadirlo al array de la vista
		List<PlayerViewBean> testList = DataTestViewModelGenerator.getTestPlayerArray();
		testList.add(aPlayerViewBean);
		//
		return new ModelAndView("UsersView", "playerList", testList);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/newTournament", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean generateTournamentForPlayers(@RequestBody List<Integer> aPlayerIds)
	{
		//TODO Call to tournaments service to generate tournament
		
		return true;
	}

}