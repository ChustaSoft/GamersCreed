package gamerscreed.rocketstats.configuration.security;

import java.io.IOException;
import java.util.Collections;

import javax.persistence.NoResultException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import gamerscreed.rocketstats.domain.implementation.PlayerBusinessLayer;
import gamerscreed.rocketstats.model.beans.PlayerViewBean;
import gamerscreed.rocketstats.model.entities.Player;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	private PlayerBusinessLayer _playerBusinessLayer;
	
	@Autowired
	public JWTLoginFilter(String url, AuthenticationManager authManager)
	{
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
		_playerBusinessLayer = new PlayerBusinessLayer();
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException 
	{
		PlayerViewBean tRetrivedCredentials = new ObjectMapper().readValue(req.getInputStream(), PlayerViewBean.class);	
		
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(tRetrivedCredentials.getUserName(), tRetrivedCredentials.getUserToken(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException 
	{
		TokenAuthenticationService.addAuthentication(res, auth.getName());
	}	

}