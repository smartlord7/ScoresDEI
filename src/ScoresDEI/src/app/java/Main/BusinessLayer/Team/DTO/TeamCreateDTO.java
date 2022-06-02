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

package Main.BusinessLayer.Team.DTO;

import Main.BusinessLayer.Base.DTO.BaseEntityCreateDTO;

import java.util.StringJoiner;

public class TeamCreateDTO implements BaseEntityCreateDTO {

    // region Private Properties

    private Long id;
    private String teamName;
    private String country;
    private String code;
    private Integer founded;
    private Long logoId;

    // endregion Private Properties

    // region Constructors

    public TeamCreateDTO() {
    }

    public TeamCreateDTO(String teamName, String country, String code, Integer founded, Long logoId) {
        this.teamName = teamName;
        this.country = country;
        this.code = code;
        this.founded = founded;
        this.logoId = logoId;
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
        return new StringJoiner(", ", TeamCreateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("teamName='" + teamName + "'")
                .add("country='" + country + "'")
                .add("code='" + code + "'")
                .add("founded=" + founded)
                .add("logoId=" + logoId)
                .toString();
    }

    // endregion Getters and Setters

}
