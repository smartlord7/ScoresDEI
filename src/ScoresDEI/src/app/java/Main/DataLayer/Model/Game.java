/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

package Main.DataLayer.Model;

import Main.DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity(name = "Game")
@Table(name = "Game")
public class Game extends AbstractAuditable<User, Long> implements BaseEntityModel {

    // region Private Properties

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
    private EventStartGame eventStartGame;

    @OneToOne
    private EventEndGame eventEndGame;

    @OneToMany(mappedBy = "game")
    List<EventInterruptGame> eventInterruptGame = new ArrayList<EventInterruptGame>();

    @OneToMany(mappedBy = "game")
    List<EventResumeGame> eventResumeGame = new ArrayList<EventResumeGame>();

    @OneToMany(mappedBy = "game")
    List<EventYellowCard> eventYellowCard = new ArrayList<EventYellowCard>();

    @OneToMany(mappedBy = "game")
    List<EventRedCard> eventRedCard = new ArrayList<EventRedCard>();

    @OneToMany(mappedBy = "game")
    List<EventGoal> eventGoal = new ArrayList<EventGoal>();

    // endregion Private Properties

    // region Constructors

    public Game() {
    }

    public Game(String place, Date startTime, Date endTime) {
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // endregion Constructors

    // region Getters and Setters

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

    public EventEndGame getEventEndGame() {
        return eventEndGame;
    }

    public void setEventEndGame(EventEndGame eventEndGame) {
        this.eventEndGame = eventEndGame;
    }

    public List<EventInterruptGame> getEventInterruptGame() {
        return eventInterruptGame;
    }

    public void setEventInterruptGame(List<EventInterruptGame> eventInterruptGame) {
        this.eventInterruptGame = eventInterruptGame;
    }

    public List<EventResumeGame> getEventResumeGame() {
        return eventResumeGame;
    }

    public void setEventResumeGame(List<EventResumeGame> eventResumeGame) {
        this.eventResumeGame = eventResumeGame;
    }

    public List<EventYellowCard> getEventYellowCard() {
        return eventYellowCard;
    }

    public void setEventYellowCard(List<EventYellowCard> eventYellowCard) {
        this.eventYellowCard = eventYellowCard;
    }

    public List<EventRedCard> getEventRedCard() {
        return eventRedCard;
    }

    public void setEventRedCard(List<EventRedCard> eventRedCards) {
        this.eventRedCard = eventRedCards;
    }

    public List<EventGoal> getEventGoal() {
        return eventGoal;
    }

    public void setEventGoal(List<EventGoal> eventGoals) {
        this.eventGoal = eventGoals;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    // endregion Getters and Setters

}
