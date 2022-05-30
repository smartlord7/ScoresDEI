package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.util.Collection;

@Entity(name = "Team")
@Table(name = "Team")
public class Team extends AbstractAuditable<User, Long> implements BaseEntityModel {
    @Column(length = 1024, nullable = false)
    private String teamName;

    @ManyToOne
    @JoinColumn(name="logo")
    private Attachment logo;

    @OneToMany
    private Collection<Player> player;

    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Attachment getLogo() {
        return logo;
    }

    public void setLogo(Attachment logo) {
        this.logo = logo;
    }

    public Collection<Player> getPlayer() {
        return player;
    }

    public void setPlayers(Collection<Player> player) {
        this.player = player;
    }
}
