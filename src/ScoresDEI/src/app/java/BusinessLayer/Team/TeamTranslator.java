package BusinessLayer.Team;

import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamListDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import DataLayer.Model.Attachment;
import DataLayer.Model.Team;

public class TeamTranslator {
    public static Team toModel(TeamCreateDTO dto) {
        return new Team(dto.getTeamName(),
                new Attachment(dto.getId()));
    }

    public static TeamListDTO toListDTO(Team model) {
        return new TeamListDTO(model.getTeamName());
    }

    public static TeamUpdateDTO toUpdateDTO(Team model) {
        return new TeamUpdateDTO(model.getTeamName());
    }

    public static TeamUpdateDTO toUpdateDTO(long id) {
        return new TeamUpdateDTO(id);
    }
}
