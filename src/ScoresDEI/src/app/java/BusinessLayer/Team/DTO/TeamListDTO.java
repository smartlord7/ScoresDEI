package BusinessLayer.Team.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;

public class TeamListDTO implements BaseEntityListDTO {
    private String teamName;

    public TeamListDTO() {
    }

    public TeamListDTO(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
