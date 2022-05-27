package DataLayer.Model;

import DataLayer.Enum.PlayerPositionEnum;
import javax.persistence.*;
import java.util.Date;

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="playerId", updatable = false, nullable = false)
    private Long id;

    @Column(length = 1024, nullable = false)
    private String playerName;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private PlayerPositionEnum position;

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
}
