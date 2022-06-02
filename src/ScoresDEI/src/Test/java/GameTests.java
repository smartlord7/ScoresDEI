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

import Main.BusinessLayer.Game.DTO.GameCreateDTO;
import Main.BusinessLayer.Game.DTO.GameUpdateDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import Main.BusinessLayer.Game.GameReader;
import Main.BusinessLayer.Game.GameWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@DataJpaTest
@RunWith(SpringRunner.class)
@EntityScan(basePackages = "Main.DataLayer.Model")
@ContextConfiguration(classes = {GameWriter.class, GameReader.class})
@EnableJpaRepositories(basePackages = "DataLayer.Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GameTests {

    // region Private properties

    @Autowired
    private GameReader reader;

    @Autowired
    private GameWriter writer;

    // endregion Private Properties

    // region Public methods

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(writer);
    }

    /**
     * Test for getting all the games.
     */
    @Test
    public void getAll() {
        System.out.println(reader.getAll());
    }

    /**
     * Test for creating a game.
     */
    @Test
    @Rollback(false)
    public void create() {
        GameCreateDTO g;

        g = new GameCreateDTO("Place " + (int) (Math.random() * (321 - 1)),
                new Date(),
                new Date(),
                (long) 0,
                (long) 1);
        g = writer.create(g);
        System.out.println(g);
    }

    /**
     * Test for updating the games.
     */
    @Test
    @Rollback(false)
    public void update() {
        GameUpdateDTO g;

        g = new GameUpdateDTO((long) 0,
                "Not here",
                new Date(),
                new Date(),
                (long) 0,
                (long) 1);
        g = writer.update(g);
        System.out.println(g);
    }

    /**
     * Test for deleting the game by Id.
     */
    @Test
    public void delete() {
        System.out.println(writer.deleteById(0));
    }

    // region Getters

    /**
     * Test for getting the events.
     */
    @Test
    public void getEvents() {
        System.out.println(reader.getEvents(0));
    }

    /**
     * Test for getting the game by Id.
     */
    @Test
    public void getById() {
        System.out.println(reader.getById(0));
    }

    // endregion Getters

    // endregion Public methods

}
