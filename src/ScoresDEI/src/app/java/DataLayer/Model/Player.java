package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import DataLayer.Enum.PlayerPositionEnum;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "Player")
@Table(name = "Player")
public class Player extends AbstractAuditable<User, Long> implements BaseEntityModel {

    // region Private Properties

    @Column(length = 1024, nullable = false)
    private String playerName;

    @Column(length = 512, nullable = false)
    private String firstName;

    @Column(length = 512, nullable = false)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private PlayerPositionEnum position;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double weight;

    @ManyToOne
    private Team team;

    @Transient
    private Long goals;

    // endregion Private Properties

    // region Constructors

    public Player() {
    }

    public Player(String playerName, Date birthDate, PlayerPositionEnum position) {
        this.playerName = playerName;
        this.birthDate = birthDate;
        this.position = position;
    }

    // endregion Constructors

    // region Getters & Setters

    public Team getTeam() {
        return team;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public PlayerPositionEnum getPosition() {
        return position;
    }

    public void setPosition(PlayerPositionEnum position) {
        this.position = position;
    }

    public Long getGoals() {
        return goals;
    }

    public void setGoals(Long goals) {
        this.goals = goals;
    }

    // endregion Getters & Setters

}
