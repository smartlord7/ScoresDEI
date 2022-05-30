package BusinessLayer.Team;

import BusinessLayer.Team.DTO.TeamCreateDTO;
import DataLayer.Model.Attachment;
import DataLayer.Model.Team;

public class TeamTranslator {
    public static Team toModel(TeamCreateDTO dto) {
        return new Team(dto.getTeamName(), new Attachment(dto.getId()));
    }
}