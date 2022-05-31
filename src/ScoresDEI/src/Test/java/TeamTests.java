import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamListDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import BusinessLayer.Team.TeamReader;
import BusinessLayer.Team.TeamWriter;
import DataLayer.Repository.TeamRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
@EntityScan(basePackages = "DataLayer.Model")
@ContextConfiguration(classes = {TeamWriter.class, TeamReader.class, TeamRepository.class})
@EnableJpaRepositories(basePackages = "DataLayer.Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamTests {

    // region Private properties

    @Autowired
    private TeamRepository teams;

    @Autowired
    private TeamWriter writer;

    @Autowired
    private TeamReader reader;

    // endregion Private Properties

    // region Public methods

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(writer);
    }

    /**
     * Test for the creation of the teams.
     */
    @Test
    @Rollback(false)
    public void createTeam() {
        TeamCreateDTO t;

        t = new TeamCreateDTO("Team " + (int) (Math.random() * (7675 - 1)), (long) 0);
        t = writer.create(t);
        System.out.println(t);
    }

    /**
     * Test for reading the teams.
     */
    @Test
    public void readAllTeams() {
        List<TeamListDTO> list;
        list = reader.getAll();

        System.out.println(list);
    }

    /**
     * Test to delete using the ID.
     */
    @Test
    public void deleteById() {
        System.out.println(writer.deleteById(0));
    }

    /**
     * Test that updates a team.
     */
    @Test
    @Rollback(false)
    public void update() {
        TeamUpdateDTO dto;

        dto = new TeamUpdateDTO((long) 0, "New team", (long) 0);
        writer.update(dto);
    }

    @Test
    public void getById() {
        System.out.println(reader.getById(0));
    }

    @Test
    public void getAllDetailed() {
        System.out.println(Arrays.toString(teams.getAllDetailed()));
    }

    @Test
    public void getAllDetailed2() {
        System.out.println(reader.getAllDetailed());
    }

    // endregion Public methods

}
