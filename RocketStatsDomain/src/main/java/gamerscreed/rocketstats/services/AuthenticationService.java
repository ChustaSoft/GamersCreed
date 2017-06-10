package gamerscreed.rocketstats.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;

import gamerscreed.rocketstats.model.beans.PlayerViewBean;

public interface AuthenticationService {

	public ResponseEntity<?> createAuthenticationToken(@RequestBody PlayerViewBean aViewBean, Device aDevice) throws AuthenticationException;
	
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest aRequest);
	
}
