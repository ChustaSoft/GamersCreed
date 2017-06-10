package gamerscreed.rocketstats.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import gamerscreed.rocketstats.configuration.security.JWTAuthenticationFilter;
import gamerscreed.rocketstats.configuration.security.JWTLoginFilter;
import gamerscreed.rocketstats.configuration.security.JwtAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
	protected void configure(HttpSecurity aHttpSecurity) throws Exception 
	{
		aHttpSecurity.csrf().disable()
			.exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint()).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers(HttpMethod.POST, "/players/login").permitAll().anyRequest().authenticated().and()
			.addFilterBefore(new JWTLoginFilter("/players/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		aHttpSecurity.headers().cacheControl();
	}	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
//		auth.userDetailsService(this._playerService)
		
		
		
//		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
	}

}
