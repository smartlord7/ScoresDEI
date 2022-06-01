package DataLayer.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "EventResumeGame")
@Table(name = "EventResumeGame")
public class EventResumeGame extends Event{

    // region Constructor

    public EventResumeGame() {
    }

    public EventResumeGame(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    // endregion Constructor

}
