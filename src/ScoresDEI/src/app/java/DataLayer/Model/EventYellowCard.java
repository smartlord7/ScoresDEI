package DataLayer.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventYellowCard")
@Table(name = "EventYellowCard")
public class EventYellowCard extends Event{
    @ManyToOne
    @JoinColumn(name = "playerId")
    private Player player;

    public EventYellowCard(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
