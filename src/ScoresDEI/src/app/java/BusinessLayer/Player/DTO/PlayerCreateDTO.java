package BusinessLayer.Player.DTO;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import DataLayer.Enum.PlayerPositionEnum;
import DataLayer.Model.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import java.util.Date;
import java.util.StringJoiner;

public class PlayerCreateDTO implements BaseEntityCreateDTO {

    // region Private Properties

    private Long id;
    private String playerName;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private PlayerPositionEnum position;
    private Long teamId;
    private String nationality;
    private Double height;
    private Double weight;

    // endregion Private Properties

    // region Getters,Setters,Constructors

    public PlayerCreateDTO() {
    }

    public PlayerCreateDTO(String playerName, String firstName, String lastName, Date birthDate, PlayerPositionEnum position, Long teamId, String nationality, Double height, Double weight) {
        this.playerName = playerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.position = position;
        this.teamId = teamId;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
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

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerCreateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("playerName='" + playerName + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("birthDate=" + birthDate)
                .add("position=" + position)
                .add("teamId=" + teamId)
                .add("nationality='" + nationality + "'")
                .add("height=" + height)
                .add("weight=" + weight)
                .toString();
    }

    // endregion Getters,Setters,Constructors

}
