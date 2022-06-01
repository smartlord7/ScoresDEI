package BusinessLayer.Player.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;
import DataLayer.Enum.PlayerPositionEnum;

import java.util.StringJoiner;

public class PlayerListDTO implements BaseEntityListDTO {

    // region Private Properties

    private Long id;
    private String playerName;
    private PlayerPositionEnum position;
    private Long teamId;
    private String teamName;

    // endregion Private Properties

    // region Getters,Setters and Constructors

    public PlayerListDTO() {
    }

    public PlayerListDTO(Long id, String playerName, PlayerPositionEnum position, Long teamId, String teamName) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPosition(PlayerPositionEnum position) {
        this.position = position;
    }

    public Long getTeamId() {
        return teamId;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerListDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("playerName='" + playerName + "'")
                .add("position=" + position)
                .add("teamId=" + teamId)
                .add("teamName='" + teamName + "'")
                .toString();
    }

    // endregion Getters,Setters and Constructors

}
