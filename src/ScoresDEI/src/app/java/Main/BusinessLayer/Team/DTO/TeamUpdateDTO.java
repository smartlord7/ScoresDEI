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

import Main.BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import Main.BusinessLayer.Player.DTO.PlayerListDTO;
import java.util.List;
import java.util.StringJoiner;

public class TeamUpdateDTO implements BaseEntityUpdateDTO {

    // region Private Properties

    private Long id;
    private String teamName;
    private String country;
    private String code;
    private Integer founded;
    private String logoPath;
    private List<PlayerListDTO> players;

    // endregion Private Properties

    // region Constructors


    public TeamUpdateDTO() {
    }

    public TeamUpdateDTO(Long id) {
        this.id = id;
    }

    public TeamUpdateDTO(Long id, String teamName, String country, String code, Integer founded, String logoPath) {
        this.id = id;
        this.teamName = teamName;
        this.country = country;
        this.code = code;
        this.founded = founded;
        this.logoPath = logoPath;
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

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logo) {
        this.logoPath = logoPath;
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

    public List<PlayerListDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerListDTO> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TeamUpdateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("teamName='" + teamName + "'")
                .add("country='" + country + "'")
                .add("code='" + code + "'")
                .add("founded=" + founded)
                .add("logoPath=" + logoPath)
                .add("players=" + players)
                .toString();
    }

    // endregion Getters and Setters
}
