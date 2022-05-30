package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity(name = "Game")
@Table(name = "Game")
public class Game extends AbstractAuditable<User, Long> implements BaseEntityModel {
    @Column(length = 1024, nullable = false)
    private String place;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @OneToOne
    private Team teamA;

    @OneToOne
    private Team teamB;

    @OneToOne
    @JoinColumn(name="id", nullable = true)
    private EventStartGame eventStartGame;

    @OneToOne
    @JoinColumn(name="id", nullable = true)
    private EventStartGame eventEndGame;

    @OneToMany
    Collection<EventInterruptGame> eventInterruptGame;

    @OneToMany
    Collection<EventResumeGame> eventResumeGame;

    @OneToMany
    Collection<EventYellowCard> eventYellowCard;

    @OneToMany
    Collection<EventRedCard> eventRedCards;

    @OneToMany
    Collection<EventGoal> eventGoals;

    public Game() {
    }

    public Game(String place, Date startTime, Date endTime) {
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
