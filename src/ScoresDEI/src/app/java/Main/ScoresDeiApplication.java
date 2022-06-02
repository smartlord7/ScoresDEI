/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

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

	// region Public Methods

	/**
	 * Main method.
	 * @param args main args.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScoresDeiApplication.class, args);
	}

	// endregion Public methods

}
