package DataLayer.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventGoal")
@Table(name = "EventGoal")
public class EventGoal extends Event{
    @ManyToOne
    @JoinColumn(name = "playerId")
    private Player player;

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

    @PostPersist
    public void changeGameScore() {
        Game g = getGame();

        if (g.getTeamA().getPlayer().contains(player)) {
            g.setScoreA(g.getScoreA() + 1);
        } else {
            g.setScoreB(g.getScoreB() + 1);
        }
    }
}
