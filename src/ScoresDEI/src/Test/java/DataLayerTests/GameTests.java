package DataLayerTests;

import BusinessLayer.Game.DTO.GameCreateDTO;
import BusinessLayer.Game.DTO.GameUpdateDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import BusinessLayer.Game.GameReader;
import BusinessLayer.Game.GameWriter;
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
@EntityScan(basePackages = "DataLayer.Model")
@ContextConfiguration(classes = {GameWriter.class, GameReader.class})
@EnableJpaRepositories(basePackages = "DataLayer.Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GameTests {
    @Autowired
    private GameReader reader;

    @Autowired
    private GameWriter writer;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(writer);
    }


    @Test
    public void readAllGames() {
        System.out.println(reader.getAll());
    }

    @Test
    @Rollback(false)
    public void createGame() {
        GameCreateDTO g;

        g = new GameCreateDTO("Place " + (int) (Math.random() * (321 - 1)),
                new Date(),
                new Date(),
                (long) 0,
                (long) 1);
        g = writer.create(g);
        System.out.println(g);
    }

    @Test
    @Rollback(false)
    public void updateGame() {
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

    @Test
    public void deleteGame() {
        System.out.println(writer.deleteById(0));
    }

    @Test
    public void readEvents() {
        System.out.println(reader.getEvents(40));
    }
}
