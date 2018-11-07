package by.iba.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/*@ComponentScan("by.iba.training")
@EnableJpaRepositories(basePackageClasses = EventRepository.class)
@EntityScan("by.iba.training.entity")*/
public class FestivalsApplication {

	//private static final Logger log = LoggerFactory.getLogger(FestivalsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FestivalsApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner demo(EventRepository repository){
		return (args -> {
			DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			repository.save(new Event("Great Thing", format.parse("22.12.2018"), format.parse("12.22.2018"), "Cool Ass Event",null, Festival.MOVIE));
		})
	}*/

}
