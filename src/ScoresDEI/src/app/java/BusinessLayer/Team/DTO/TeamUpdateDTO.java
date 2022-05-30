package BusinessLayer.Team.DTO;

import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;

import java.util.StringJoiner;

public class TeamUpdateDTO implements BaseEntityUpdateDTO {
    private Long id;
    private String teamName;
    private Long logoId;

    public TeamUpdateDTO(Long id) {
        this.id = id;
    }

    public TeamUpdateDTO(String teamName) {
        this.teamName = teamName;
    }

    public TeamUpdateDTO(Long id, String teamName, Long logoId) {
        this.id = id;
        this.teamName = teamName;
        this.logoId = logoId;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", TeamUpdateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("teamName='" + teamName + "'")
                .add("logoId=" + logoId)
                .toString();
    }
}
