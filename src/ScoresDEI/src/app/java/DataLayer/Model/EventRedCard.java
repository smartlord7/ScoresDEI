package DataLayer.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventRedCard")
@Table(name = "EventRedCard")
public class EventRedCard extends Event{

    // region Private Properties

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private Player player;

    // endregion Private Properties

    // region Getters, Setters and Constructors

    public EventRedCard(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // endregion Getters, Setters and Constructors

}
