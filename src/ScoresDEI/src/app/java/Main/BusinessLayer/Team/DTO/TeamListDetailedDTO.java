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

import Main.BusinessLayer.Base.DTO.BaseEntityListDTO;

import java.util.StringJoiner;

public class TeamListDetailedDTO implements BaseEntityListDTO {

    // region Private Properties

    private Long teamId;
    private String teamName;
    private Long games;
    private Long victories;
    private Long losses;
    private Long draws;

    // region Private Properties

    // region Constructors

    public TeamListDetailedDTO() {
    }

    public TeamListDetailedDTO(Long teamId, String teamName, Long games, Long victories, Long draws, Long losses) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.games = games;
        this.victories = victories;
        this.draws = draws;
        this.losses = losses;
    }

    // endregion Constructors

    // region Getters and Setters

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

    public Long getGames() {
        return games;
    }

    public void setGames(Long games) {
        this.games = games;
    }

    public Long getVictories() {
        return victories;
    }

    public void setVictories(Long victories) {
        this.victories = victories;
    }

    public Long getLosses() {
        return losses;
    }

    public void setLosses(Long losses) {
        this.losses = losses;
    }

    public Long getDraws() {
        return draws;
    }

    public void setDraws(Long draws) {
        this.draws = draws;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TeamListDetailedDTO.class.getSimpleName() + "[", "]")
                .add("teamId=" + teamId)
                .add("teamName='" + teamName + "'")
                .add("games=" + games)
                .add("victories=" + victories)
                .add("losses=" + losses)
                .add("draws=" + draws)
                .toString();
    }

    // endregion Getters and Setters

}
