package BusinessLayer.Player.DTO;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import DataLayer.Enum.PlayerPositionEnum;
import DataLayer.Model.Team;

import java.util.Date;
import java.util.StringJoiner;

public class PlayerCreateDTO implements BaseEntityCreateDTO {

    // region Private Properties

    private Long id;
    private String playerName;
    private Date birthDate;
    private PlayerPositionEnum position;
    private Long teamId;
    private Team team;

    // endregion Private Properties

    // region Getters,Setters,Constructors

    public PlayerCreateDTO() {
    }

    public PlayerCreateDTO(String playerName, Date birthDate, PlayerPositionEnum position, Long teamId) {
        this.playerName = playerName;
        this.birthDate = birthDate;
        this.position = position;
        this.teamId = teamId;
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

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerCreateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("playerName='" + playerName + "'")
                .add("birthDate=" + birthDate)
                .add("position=" + position)
                .add("teamId=" + teamId)
                .toString();
    }

    // endregion Getters,Setters,Constructors

}
