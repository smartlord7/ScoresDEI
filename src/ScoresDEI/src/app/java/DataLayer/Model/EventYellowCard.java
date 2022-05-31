package DataLayer.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventYellowCard")
@Table(name = "EventYellowCard")
public class EventYellowCard extends Event{

    // region Private Properties

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private Player player;

    // endregion Private Properties

    public EventYellowCard(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    // region Getters and Setters

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // endregion Getters and Setters

}
