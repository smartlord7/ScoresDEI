import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import BusinessLayer.Player.PlayerReader;
import BusinessLayer.Player.PlayerWriter;
import DataLayer.Enum.PlayerPositionEnum;
import DataLayer.Repository.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PlayerRepository players;

    @Autowired
    private PlayerReader reader;

    @Autowired
    private PlayerWriter writer;

    @Test
    public void getBestScorer() {
        var bestScorer = players.getBestScorer();
        System.out.println(Arrays.toString(bestScorer));
    }

    @Test
    public void getBestScorer2() {
        System.out.println(reader.getBestScorer());
    }

    @Test
    @Rollback(false)
    public void create() {
        System.out.println(writer.create(
                new PlayerCreateDTO("Sancho Simões",
                        new Date(),
                        PlayerPositionEnum.GK,
                        (long) 0)));
    }

    @Test
    public void deleteById() {
        System.out.println(writer.deleteById(68));
    }

    @Test
    @Rollback(false)
    public void update() {
        System.out.println(writer.update(
                new PlayerUpdateDTO((long) 68, "Sancho Simões",
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
        System.out.println(reader.getById(68));
    }
}
