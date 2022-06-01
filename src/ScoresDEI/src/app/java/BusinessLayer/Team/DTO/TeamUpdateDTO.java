package BusinessLayer.Team.DTO;

import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Model.Attachment;

import java.util.StringJoiner;

public class TeamUpdateDTO implements BaseEntityUpdateDTO {

    // region Private Properties

    private Long id;
    private String teamName;
    private Long logoId;
    private Attachment logo;

    // endregion Private Properties

    // region Getters,Setters and Constructors


    public TeamUpdateDTO() {
    }

    public TeamUpdateDTO(Long id) {
        this.id = id;
    }

    public TeamUpdateDTO(Long id, String teamName, Long logoId) {
        this.id = id;
        this.teamName = teamName;
        this.logoId = logoId;
    }

    public TeamUpdateDTO(Long id, String teamName, Attachment logo) {
        this.id = id;
        this.teamName = teamName;
        this.logo = logo;
    }

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

    public Long getLogoId() {
        return logoId;
    }

    public void setLogoId(Long logoId) {
        this.logoId = logoId;
    }

    public Attachment getLogo() {
        return logo;
    }

    public void setLogo(Attachment logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TeamUpdateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("teamName='" + teamName + "'")
                .add("logoId=" + logoId)
                .add("logo=" + logo)
                .toString();
    }

    // endregion Getters,Setters and Constructors

}
