package Mk.JD2_95_22.fitness;

import Mk.JD2_95_22.fitness.config.properties.JWTProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableConfigurationProperties({JWTProperty.class})
@SpringBootApplication
public class FitnessApplication {


	public static void main(String[] args) {
		SpringApplication.run(FitnessApplication.class, args);
	}

}
