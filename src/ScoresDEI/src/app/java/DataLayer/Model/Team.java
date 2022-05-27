package DataLayer.Model;

import javax.persistence.*;

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="teamId", updatable = false, nullable = false)
    private Long id;

    @Column(length = 1024, nullable = false)
    private String teamName;

    @ManyToOne
    @JoinColumn(name="attachmentId")
    private Attachment logo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
