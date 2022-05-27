package DataLayer.Model;

import DataLayer.Enum.PlayerPositionEnum;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "Player")
@Table(name = "Player")
public class Player extends AbstractAuditable<Long, User> {
    @Column(length = 1024, nullable = false)
    private String playerName;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private PlayerPositionEnum position;

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
