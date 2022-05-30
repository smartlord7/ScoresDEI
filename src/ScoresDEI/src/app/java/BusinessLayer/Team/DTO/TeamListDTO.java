package BusinessLayer.Team.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;

public class TeamListDTO implements BaseEntityListDTO {
    private Long id;
    private String teamName;

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
}
