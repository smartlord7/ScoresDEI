package BusinessLayer.Player.DTO;

import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Enum.PlayerPositionEnum;
import java.util.Date;
import java.util.StringJoiner;

public class PlayerUpdateDTO implements BaseEntityUpdateDTO {

    // region Private Properties

    private Long id;
    private String playerName;
    private Date birthDate;
    private PlayerPositionEnum position;
    private Long goals;
    private Long teamId;
    private String teamName;
    private String firstName;
    private String lastName;
    private String nationality;
    private Double height;
    private Double weight;

    // endregion Private Properties

    // region Getters,Setters and Constructors

    public PlayerUpdateDTO() {
    }

    public PlayerUpdateDTO(Long id) {
        this.id = id;
    }

    public PlayerUpdateDTO(Long id, String playerName, PlayerPositionEnum position, long goals, Long teamId, String teamName, String nationality) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
        this.goals = goals;
        this.teamId = teamId;
        this.teamName = teamName;
        this.nationality = nationality;
    }

    public PlayerUpdateDTO(Long id, String playerName, PlayerPositionEnum position, Date birthDate, Long teamId) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
        this.birthDate = birthDate;
        this.teamId = teamId;
    }

    public PlayerUpdateDTO(Long id, String playerName, Date birthDate, PlayerPositionEnum position, Long teamId, String teamName, String firstName, String lastName, String nationality, Double height, Double weight) {
        this.id = id;
        this.playerName = playerName;
        this.birthDate = birthDate;
        this.position = position;
        this.teamId = teamId;
        this.teamName = teamName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerPositionEnum getPosition() {
        return position;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeam(Long teamId) {
        this.teamId = teamId;
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

    public Long getId() {
        return id;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerUpdateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("playerName='" + playerName + "'")
                .add("birthDate=" + birthDate)
                .add("position=" + position)
                .add("goals=" + goals)
                .add("teamId=" + teamId)
                .add("teamName='" + teamName + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("nationality='" + nationality + "'")
                .add("height=" + height)
                .add("weight=" + weight)
                .toString();
    }

    // endregion Getters,Setters and Constructors

}
