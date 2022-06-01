package BusinessLayer.Team.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;

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

    // region Getters,Setters and Constructors

    public TeamListDetailedDTO() {
    }

    public TeamListDetailedDTO(Long teamId, String teamName, Long games, Long victories, Long losses, Long draws) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.games = games;
        this.victories = victories;
        this.losses = losses;
        this.draws = draws;
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

    // endregion Getters,Setters and Constructors

}
