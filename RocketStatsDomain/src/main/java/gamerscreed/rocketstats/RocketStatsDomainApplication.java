package gamerscreed.rocketstats;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("gamerscreed.rocketstats")
public class RocketStatsDomainApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RocketStatsDomainApplication.class, args);

		System.out.println("Loading RocketStatsApp - Domain Layer...");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

	@Override
	public void run(String... arg0) throws Exception {
		//Thread.currentThread().join();		
	}
}
