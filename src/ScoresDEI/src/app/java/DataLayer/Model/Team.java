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

    @Column(length = 512, nullable = false)
    private String country;

    @Column(length = 64, nullable = false)
    private String code;

    private Integer founded;

    @ManyToOne
    @JoinColumn(name="logo")
    private Attachment logo;

    @OneToMany
    private List<Player> player = new ArrayList<Player>();

    // endregion Private Properties

    // region Getters,Setters and Constructor

    public Team() {
    }

    public Team(String teamName, String country, String code, Integer founded) {
        this.teamName = teamName;
        this.country = country;
        this.code = code;
        this.founded = founded;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    // region Getters,Setters and Constructor

}
