package BusinessLayer.Team;

import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamListDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import DataLayer.Model.Team;

public class TeamTranslator {

    // region Public Methods

    public static Team toModel(TeamCreateDTO dto) {
        return new Team(
                dto.getTeamName(),
                dto.getCountry(),
                dto.getCode(),
                dto.getFounded()
                );
    }

    public static TeamListDTO toListDTO(Team model) {
        return new TeamListDTO(model.getId(),
                model.getTeamName());
    }

    public static TeamUpdateDTO toUpdateDTO(long id) {
        return new TeamUpdateDTO(id);
    }

    public static TeamUpdateDTO toUpdateDTO(Team model) {
        return new TeamUpdateDTO(model.getId(),
                model.getTeamName(),
                model.getLogo());
    }

    public static void applyChanges(Team model, TeamUpdateDTO dto) {
        model.setTeamName(dto.getTeamName());
    }

    // endregion Public Methods

}
