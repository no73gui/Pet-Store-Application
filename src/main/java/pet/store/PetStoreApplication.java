package pet.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// denote this w/ SpringBootApplication class level annotation
@SpringBootApplication
public class PetStoreApplication {

	public static void main(String[] args) {
		
		// start spring boot application using .run.
		SpringApplication.run(PetStoreApplication.class, args);

	}

}
