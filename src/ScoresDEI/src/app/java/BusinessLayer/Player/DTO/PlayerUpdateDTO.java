package BusinessLayer.Player.DTO;

import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Enum.PlayerPositionEnum;

import java.util.StringJoiner;

public class PlayerUpdateDTO implements BaseEntityUpdateDTO {
    private Long id;
    private String playerName;
    private PlayerPositionEnum position;
    private Long goals;

    public PlayerUpdateDTO() {
    }

    public PlayerUpdateDTO(Long id) {
        this.id = id;
    }

    public PlayerUpdateDTO(String playerName, PlayerPositionEnum position, Long goals) {
        this.playerName = playerName;
        this.position = position;
        this.goals = goals;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                .add("position=" + position)
                .add("goals=" + goals)
                .toString();
    }
}
