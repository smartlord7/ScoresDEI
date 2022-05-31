package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Team")
@Table(name = "Team")
public class Team extends AbstractAuditable<User, Long> implements BaseEntityModel {

    // region Private Properties

    @Column(length = 1024, nullable = false)
    private String teamName;

    @ManyToOne
    @JoinColumn(name="logo")
    private Attachment logo;

    @OneToMany
    private List<Player> player = new ArrayList<Player>();

    // endregion Private Properties

    // region Getters,Setters and Constructor

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

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayers(List<Player> player) {
        this.player = player;
    }

    // region Getters,Setters and Constructor

}
