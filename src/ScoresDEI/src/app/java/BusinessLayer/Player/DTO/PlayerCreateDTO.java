package BusinessLayer.Player.DTO;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import DataLayer.Enum.PlayerPositionEnum;
import java.util.Date;
import java.util.StringJoiner;

public class PlayerCreateDTO implements BaseEntityCreateDTO {
    private Long id;
    private String playerName;
    private Date birthDate;
    private PlayerPositionEnum position;

    public PlayerCreateDTO() {
    }

    public PlayerCreateDTO(String playerName, Date birthDate, PlayerPositionEnum position) {
        this.playerName = playerName;
        this.birthDate = birthDate;
        this.position = position;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerCreateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("playerName='" + playerName + "'")
                .add("birthDate=" + birthDate)
                .add("position=" + position)
                .toString();
    }
}
