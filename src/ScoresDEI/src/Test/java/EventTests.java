import BusinessLayer.Event.DTO.EventCreateDTO;
import BusinessLayer.Event.EventReader;
import BusinessLayer.Event.EventWriter;
import DataLayer.Enum.EventTypeEnum;
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
import java.util.Date;

@DataJpaTest
@RunWith(SpringRunner.class)
@EntityScan(basePackages = "DataLayer.Model")
@ContextConfiguration(classes = {EventWriter.class, EventReader.class})
@EnableJpaRepositories(basePackages = "DataLayer.Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EventTests {

    // region Private properties

    @Autowired
    private EventReader reader;

    @Autowired
    private EventWriter writer;

    // endregion Private Properties

    // region Public methods

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(writer);
    }

    /**
     * Test for the creation of events.
     */
    @Test
    @Rollback(false)
    public void createGoalEvent() {
        EventCreateDTO goal = new EventCreateDTO(EventTypeEnum.GOAL,
                new Date(),
                "Test event",
                (long) 40,
                (long) 1);
        System.out.println(writer.create(goal));
    }

    /**
     * Method used to create end game events.
     */
    @Test
    @Rollback(false)
    public void createEndGameEvent() {
        EventCreateDTO end = new EventCreateDTO(EventTypeEnum.END_GAME,
                new Date(),
                "Test event",
                (long) 40,
                (long) 1);
        System.out.println(writer.create(end));
    }

    // endregion Public methods

}
