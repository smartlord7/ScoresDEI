package BusinessLayer.Team.DTO;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;

import java.util.StringJoiner;

public class TeamCreateDTO implements BaseEntityCreateDTO {
    private Long id;
    private String teamName;
    private Long logoId;

    public TeamCreateDTO() {
    }

    public TeamCreateDTO(String teamName, Long logoId) {
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
        return new StringJoiner(", ", TeamCreateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("teamName='" + teamName + "'")
                .add("logoId=" + logoId)
                .toString();
    }
}
