package BusinessLayer.Team.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;

import java.util.StringJoiner;

public class TeamListDTO implements BaseEntityListDTO {

    // region Private Properties

    private Long id;
    private String teamName;

    // endregion Private Properties

    // region Getters,Setters and Constructors

    public TeamListDTO() {
    }

    public TeamListDTO(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", TeamListDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("teamName='" + teamName + "'")
                .toString();
    }

    // endregion Getters,Setters and Constructors

}
