package gamerscreed.rocketstats.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("LoginView");
        registry.addViewController("/users").setViewName("UsersView");
        registry.addViewController("/tournaments").setViewName("TournamentsView");
    }

}