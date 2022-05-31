package BusinessLayer.Player.DTO;

import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Enum.PlayerPositionEnum;
import java.util.Date;
import java.util.StringJoiner;

public class PlayerUpdateDTO implements BaseEntityUpdateDTO {
    private Long id;
    private String playerName;
    private Date birthDate;
    private PlayerPositionEnum position;
    private Long goals;
    private Long teamId;

    public PlayerUpdateDTO() {
    }

    public PlayerUpdateDTO(Long id) {
        this.id = id;
    }

    public PlayerUpdateDTO(Long id, String playerName, PlayerPositionEnum position, long goals) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
        this.goals = goals;
    }

    public PlayerUpdateDTO(Long id, String playerName, PlayerPositionEnum position, Date birthDate, Long teamId) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
        this.birthDate = birthDate;
        this.teamId = teamId;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerUpdateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("playerName='" + playerName + "'")
                .add("birthDate=" + birthDate)
                .add("position=" + position)
                .add("goals=" + goals)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
