package DataLayer.Model;

import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;

@Entity(name = "Team")
@Table(name = "Team")
public class Team extends AbstractAuditable<Long, User> {
    @Column(length = 1024, nullable = false)
    private String teamName;

    @ManyToOne
    @JoinColumn(name="id")
    private Attachment logo;

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
