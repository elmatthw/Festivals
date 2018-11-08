package by.iba.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/*@ComponentScan("by.iba.training")
@EnableJpaRepositories(basePackageClasses = EventRepository.class)
@EntityScan("by.iba.training.entity")*/
public class FestivalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FestivalsApplication.class, args);
	}

}
