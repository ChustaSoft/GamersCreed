package gamerscreed.rocketstats.utilities;

import org.springframework.web.client.RestTemplate;

import gamerscreed.profiler.structures.DataSender;
import gamerscreed.profiler.structures.SecurityInfo;

public class WebServiceControllerCallDispatcher {

	RestTemplate restTemplate = new RestTemplate();
	
	protected DataSender MAkeRequest(String aUrl, SecurityInfo aSecurityInfo){	
		return null;
	}
}
