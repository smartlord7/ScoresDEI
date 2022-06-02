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

package Main.BusinessLayer.Player.DTO;

import Main.BusinessLayer.Base.DTO.BaseEntityListDTO;
import Main.DataLayer.Enum.PlayerPositionEnum;

import java.util.StringJoiner;

public class PlayerListDTO implements BaseEntityListDTO {

    // region Private Properties

    private Long id;
    private String playerName;
    private PlayerPositionEnum position;
    private Long teamId;
    private String teamName;
    private String nationality;

    // endregion Private Properties

    // region Constructors

    public PlayerListDTO() {
    }

    public PlayerListDTO(Long id, String playerName, PlayerPositionEnum position, Long teamId, String teamName, String nationality) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
        this.teamId = teamId;
        this.teamName = teamName;
        this.nationality = nationality;
    }

    // endregion Constructors

    // region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerPositionEnum getPosition() {
        return position;
    }

    public void setPosition(PlayerPositionEnum position) {
        this.position = position;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerListDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("playerName='" + playerName + "'")
                .add("position=" + position)
                .add("teamId=" + teamId)
                .add("teamName='" + teamName + "'")
                .add("nationality='" + nationality + "'")
                .toString();
    }

    // endregion Getters and Setters

}
