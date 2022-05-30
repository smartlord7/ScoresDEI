package DataLayer.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "EventStartGame")
@Table(name = "EventStartGame")
public class EventStartGame extends Event{
    public EventStartGame(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }
}
