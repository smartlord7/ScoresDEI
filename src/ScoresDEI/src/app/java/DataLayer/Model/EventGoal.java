package DataLayer.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventGoal")
@Table(name = "EventGoal")
public class EventGoal extends Event{
    @ManyToOne
    @JoinColumn(name = "playerId")
    private Player player;

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
