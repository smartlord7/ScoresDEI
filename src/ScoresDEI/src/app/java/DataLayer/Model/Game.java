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

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer scoreA;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer scoreB;

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

    @OneToMany(mappedBy = "game")
    Collection<EventInterruptGame> eventInterruptGame;

    @OneToMany(mappedBy = "game")
    Collection<EventResumeGame> eventResumeGame;

    @OneToMany(mappedBy = "game")
    Collection<EventYellowCard> eventYellowCard;

    @OneToMany(mappedBy = "game")
    Collection<EventRedCard> eventRedCard;

    @OneToMany(mappedBy = "game")
    Collection<EventGoal> eventGoal;

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

    public Integer getScoreA() {
        return scoreA;
    }

    public void setScoreA(Integer scoreA) {
        this.scoreA = scoreA;
    }

    public Integer getScoreB() {
        return scoreB;
    }

    public void setScoreB(Integer scoreB) {
        this.scoreB = scoreB;
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

    public EventStartGame getEventStartGame() {
        return eventStartGame;
    }

    public void setEventStartGame(EventStartGame eventStartGame) {
        this.eventStartGame = eventStartGame;
    }

    public EventStartGame getEventEndGame() {
        return eventEndGame;
    }

    public void setEventEndGame(EventStartGame eventEndGame) {
        this.eventEndGame = eventEndGame;
    }

    public Collection<EventInterruptGame> getEventInterruptGame() {
        return eventInterruptGame;
    }

    public void setEventInterruptGame(Collection<EventInterruptGame> eventInterruptGame) {
        this.eventInterruptGame = eventInterruptGame;
    }

    public Collection<EventResumeGame> getEventResumeGame() {
        return eventResumeGame;
    }

    public void setEventResumeGame(Collection<EventResumeGame> eventResumeGame) {
        this.eventResumeGame = eventResumeGame;
    }

    public Collection<EventYellowCard> getEventYellowCard() {
        return eventYellowCard;
    }

    public void setEventYellowCard(Collection<EventYellowCard> eventYellowCard) {
        this.eventYellowCard = eventYellowCard;
    }

    public Collection<EventRedCard> getEventRedCard() {
        return eventRedCard;
    }

    public void setEventRedCard(Collection<EventRedCard> eventRedCards) {
        this.eventRedCard = eventRedCards;
    }

    public Collection<EventGoal> getEventGoal() {
        return eventGoal;
    }

    public void setEventGoal(Collection<EventGoal> eventGoals) {
        this.eventGoal = eventGoals;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
