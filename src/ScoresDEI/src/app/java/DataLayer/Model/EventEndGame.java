package DataLayer.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "EventEndGame")
@Table(name = "EventEndGame")
public class EventEndGame extends Event{
    public EventEndGame(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }
}
