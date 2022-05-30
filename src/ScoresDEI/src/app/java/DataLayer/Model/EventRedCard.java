package DataLayer.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventRedCard")
@Table(name = "EventRedCard")
public class EventRedCard extends Event{
    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private Player player;

    public EventRedCard(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
