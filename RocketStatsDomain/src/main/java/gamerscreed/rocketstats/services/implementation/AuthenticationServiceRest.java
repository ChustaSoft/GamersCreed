package gamerscreed.rocketstats.services.implementation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import gamerscreed.rocketstats.domain.implementation.PlayerBusinessLayer;
import gamerscreed.rocketstats.model.beans.PlayerDetails;
import gamerscreed.rocketstats.model.beans.PlayerViewBean;
import gamerscreed.rocketstats.services.AuthenticationService;
import gamerscreed.rocketstats.utilities.JwtAuthenticationResponse;
import gamerscreed.rocketstats.utilities.JwtTokenUtil;

public class AuthenticationServiceRest implements AuthenticationService 
{

	@Value("${jwt.header}")
    private String tokenHeader;
	
	@Autowired
    private AuthenticationManager _authenticationManager;

	@Autowired
	private PlayerBusinessLayer _playerBusinessLayer;
	
    @Autowired
    private JwtTokenUtil _jwtTokenUtil;
    
	
	@Override
	public ResponseEntity<?> createAuthenticationToken(PlayerViewBean aViewBean, Device aDevice) throws AuthenticationException {

		final Authentication tAuthentication = getFinalAuthentication(aViewBean);
		final UserDetails tUserDetails = _playerBusinessLayer.loadUserByUsername(aViewBean.getUserName());
        final String tToken = _jwtTokenUtil.generateToken(tUserDetails, aDevice);
        
        SecurityContextHolder.getContext().setAuthentication(tAuthentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(tToken));
	}

	@Override
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest aRequest) 
	{
		String tToken = aRequest.getHeader(tokenHeader);
        String tUsername = _jwtTokenUtil.getUsernameFromToken(tToken);
        PlayerDetails tUser = (PlayerDetails) _playerBusinessLayer.loadUserByUsername(tUsername);

        if (_jwtTokenUtil.canTokenBeRefreshed(tToken, tUser.getLastPasswordResetDate())) 
        {
            String tRefreshedToken = _jwtTokenUtil.refreshToken(tToken);
            
            return ResponseEntity.ok(new JwtAuthenticationResponse(tRefreshedToken));
        } 
        else 
        {
            return ResponseEntity.badRequest().body(null);
        }
	}

	
	private Authentication getFinalAuthentication(PlayerViewBean aViewBean) 
	{
		return _authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				aViewBean.getUserName(),
				aViewBean.getUserToken()
			)
		);		
	}

	
	
}
