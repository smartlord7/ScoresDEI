/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

package Main.DataLayer.Model;

import Main.DataLayer.Base.BaseEntityModel;
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

    private boolean imported;

    @ManyToOne
    @JoinColumn(name="logo")
    private Attachment logo;

    @OneToMany
    private List<Player> player = new ArrayList<Player>();

    // endregion Private Properties

    // region Constructors

    public Team() {
    }

    public Team(String teamName, String country, String code, Integer founded) {
        this.teamName = teamName;
        this.country = country;
        this.code = code;
        this.founded = founded;
    }

    // endregion Constructors

    // region Getters and Setters

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

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    // endregion Getters and Setters

}
