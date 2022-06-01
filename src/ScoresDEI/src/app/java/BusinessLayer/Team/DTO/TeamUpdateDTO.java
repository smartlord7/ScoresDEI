package BusinessLayer.Team.DTO;

import BusinessLayer.Attachment.DTO.AttachmentUpdateDTO;
import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Model.Attachment;

import java.util.StringJoiner;

public class TeamUpdateDTO implements BaseEntityUpdateDTO {

    // region Private Properties

    private Long id;
    private String teamName;
    private String country;
    private String code;
    private Integer founded;
    private Long logoId;
    private AttachmentUpdateDTO logo;

    // endregion Private Properties

    // region Constructors


    public TeamUpdateDTO() {
    }

    public TeamUpdateDTO(Long id) {
        this.id = id;
    }

    public TeamUpdateDTO(Long id, String teamName, String country, String code, Integer founded, Long logoId) {
        this.id = id;
        this.teamName = teamName;
        this.country = country;
        this.code = code;
        this.founded = founded;
        this.logoId = logoId;
    }

    public TeamUpdateDTO(Long id, String teamName, AttachmentUpdateDTO logo) {
        this.id = id;
        this.teamName = teamName;
        this.logo = logo;
    }


    // endregion Constructors

    // region Getters and Setters

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

    public AttachmentUpdateDTO getLogo() {
        return logo;
    }

    public void setLogo(AttachmentUpdateDTO logo) {
        this.logo = logo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", TeamUpdateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("teamName='" + teamName + "'")
                .add("country='" + country + "'")
                .add("code='" + code + "'")
                .add("founded=" + founded)
                .add("logoId=" + logoId)
                .add("logo=" + logo)
                .toString();
    }

    // endregion Getters and Setters
}
