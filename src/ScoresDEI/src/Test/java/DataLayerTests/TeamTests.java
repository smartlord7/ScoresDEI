package DataLayerTests;

import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.TeamWriter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@EntityScan(basePackages = "DataLayer.Model")
@ContextConfiguration(classes = {TeamWriter.class})
@EnableJpaRepositories(basePackages = "DataLayer.Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamTests {
    @Autowired
    private TeamWriter writer;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(writer);
    }

    @Test
    public void writeTeam() {
        TeamCreateDTO t;

        t = new TeamCreateDTO("Team 1", (long) 1);
        t = writer.create(t);
        System.out.println(t);
    }
}
