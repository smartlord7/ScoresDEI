package Main;

import BusinessLayer.Event.EventReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScoresDeiApplication {

	// region Public methods

	/**
	 * Main method.
	 * @param args main args.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScoresDeiApplication.class, args);

		var reader = new EventReader();
	}

	// endregion Public methods

}
