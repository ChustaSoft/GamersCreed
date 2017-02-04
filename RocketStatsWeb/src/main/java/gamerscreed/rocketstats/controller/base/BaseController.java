package gamerscreed.rocketstats.controller.base;

import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gamerscreed.rocketstats.utilities.WebServiceControllerCallDispatcher;

public abstract class BaseController {

	protected WebServiceControllerCallDispatcher callDispatcher;
	
	protected final String SessionConst = "userSession";
	
	public BaseController(){
		callDispatcher = new WebServiceControllerCallDispatcher();
	}
	
	public String serializeObjectToJson(Object aObject){
		ObjectMapper mapper = new ObjectMapper();
		String jsonStringObject = new String();
		try {
			jsonStringObject = mapper.writeValueAsString(aObject);
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
		return jsonStringObject;		
	}	
	
	public abstract ModelAndView viewIndex();
		
}
