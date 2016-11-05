package gamerscreed.rocketstats.utilities;

import org.springframework.web.client.RestTemplate;

import gamerscreed.profiler.structures.DataSender;

public class WebServiceControllerCallDispatcher {

	RestTemplate restTemplate = new RestTemplate();
	
	public DataSender MakeRequest(String aUrl, DataSender aData){	
		return null;
	}
}
