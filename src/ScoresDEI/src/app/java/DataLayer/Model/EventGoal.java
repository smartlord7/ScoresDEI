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

    @PostUpdate

    // region Public Methods

    /**
     * Method to change the game score.
     */
    @PostPersist
    public void changeGameScore() {
        Game g = getGame();
        if (isApproved()) {
            if (g.getTeamA().getPlayer().contains(player)) {
                g.setScoreA(g.getScoreA() + 1);
            } else {
                g.setScoreB(g.getScoreB() + 1);
            }
        }
    }
    // endregion Public Methods

}
