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

import Main.BusinessLayer.Player.DTO.PlayerCreateDTO;
import Main.BusinessLayer.Player.DTO.PlayerUpdateDTO;
import Main.BusinessLayer.Player.PlayerReader;
import Main.BusinessLayer.Player.PlayerWriter;
import Main.DataLayer.Enum.PlayerPositionEnum;
import Main.DataLayer.Repository.PlayerRepository;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.Date;

@DataJpaTest
@RunWith(SpringRunner.class)
@EntityScan(basePackages = "DataLayer.Model")
@ContextConfiguration(classes = {PlayerRepository.class, PlayerReader.class, PlayerWriter.class})
@EnableJpaRepositories(basePackages = "DataLayer.Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerTests {
    @Value("${sports_api.api_key}")
    private String API_KEY;

    // region Private properties

    @Autowired
    private PlayerRepository players;

    @Autowired
    private PlayerReader reader;

    @Autowired
    private PlayerWriter writer;

    // endregion Private Properties

    // region Public methods

    /**
     * Test for the retrieval of the best scorer.
     */
    @Test
    public void getBestScorer() {
        var bestScorer = players.getBestScorer();
        System.out.println(Arrays.toString(bestScorer));
    }

    /**
     * Test for the retrieval of the best scorer.
     */
    @Test
    public void getBestScorer2() {
        System.out.println(reader.getBestScorer());
    }

    /**
     * Test for the player creation.
     */
    @Test
    @Rollback(false)
    public void create() {
        System.out.println(writer.create(
                new PlayerCreateDTO(
                        "Sancho S.",
                        "Sancho",
                        "Simões",
                        new Date(),
                        PlayerPositionEnum.GK,
                        (long) 0,
                        "Portuguese",
                        1.90,
                        100.0)));
    }

    /**
     * Test for deleting by the id.
     */
    @Test
    public void deleteById() {
        System.out.println(writer.deleteById(0));
    }

    /**
     * Test for the player update.
     */
    @Test
    @Rollback(false)
    public void update() {
        System.out.println(writer.update(
                new PlayerUpdateDTO((long) 0, "Sancho Simões",
                        PlayerPositionEnum.GK,
                        new Date(),
                        (long) 1)));
    }

    @Test
    public void getAll() {
        System.out.println(reader.getAll());
    }

    @Test
    public void getById() {
        System.out.println(reader.getById(0));
    }


    @Test
    @Rollback(false)
    public void importViaSportsAPI() throws UnirestException {
        writer.importViaSportsAPI(API_KEY, (long)39, (long)2021, (long)1);
    }
    // endregion Public methods

}
