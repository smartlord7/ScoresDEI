package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;

@Entity(name = "Team")
@Table(name = "Team")
public class Team extends AbstractAuditable<User, Long> implements BaseEntityModel {
    @Column(length = 1024, nullable = false)
    private String teamName;

    @ManyToOne
    @JoinColumn(name="logo")
    private Attachment logo;

    public Team(String teamName, Attachment logo) {
        this.teamName = teamName;
        this.logo = logo;
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
}
