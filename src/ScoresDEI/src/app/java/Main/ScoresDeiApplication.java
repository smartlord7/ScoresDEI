package Main;

import BusinessLayer.Event.EventReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"DataLayer", "BusinessLayer", "PresentationLayer"})
@EnableJpaRepositories(basePackages = "DataLayer")
@EntityScan(basePackages = "DataLayer")
@SpringBootApplication
public class ScoresDeiApplication {

	// region Public methods

	/**
	 * Main method.
	 * @param args main args.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScoresDeiApplication.class, args);
	}

	// endregion Public methods

}
