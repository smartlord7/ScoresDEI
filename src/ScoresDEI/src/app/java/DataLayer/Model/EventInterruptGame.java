package DataLayer.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "EventInterruption")
@Table(name = "EventInterruption")
public class EventInterruptGame extends Event{

    // region Constructor

    public EventInterruptGame(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    // endregion Constructor

}
