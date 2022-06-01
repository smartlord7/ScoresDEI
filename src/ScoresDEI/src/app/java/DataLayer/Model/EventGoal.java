package DataLayer.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventGoal")
@Table(name = "EventGoal")
public class EventGoal extends Event{

    // region Private Properties

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private Player player;

    // endregion Private Properties

    // region Getters,Setters and Constructors

    public EventGoal() {
        super();
    }

    public EventGoal(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
