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

package Main.BusinessLayer.Team;

import Main.BusinessLayer.Team.DTO.TeamCreateDTO;
import Main.BusinessLayer.Team.DTO.TeamListDTO;
import Main.BusinessLayer.Team.DTO.TeamUpdateDTO;
import Main.BusinessLayer.Team.Import.TeamSportsAPIImport;
import Main.DataLayer.Model.Team;

public class TeamTranslator {

    // region Public Methods

    public static Team toModel(TeamSportsAPIImport dto) {
        Team t = new Team(
                dto.getName(),
                dto.getCountry(),
                dto.getCode(),
                dto.getFounded(),
                dto.getLogo()
        );
        t.setImported(true);

        return t;
    }

    public static Team toModel(TeamCreateDTO dto) {
        return new Team(
                dto.getTeamName(),
                dto.getCountry(),
                dto.getCode(),
                dto.getFounded(),
                dto.getLogoPath()
                );
    }

    public static TeamListDTO toListDTO(Team model) {
        return new TeamListDTO(
                model.getId(),
                model.getTeamName(),
                model.getCountry(),
                model.getCode());
    }

    public static TeamUpdateDTO toUpdateDTO(long id) {
        return new TeamUpdateDTO(id);
    }

    public static TeamUpdateDTO toUpdateDTO(Team model) {
        return new TeamUpdateDTO(
                model.getId(),
                model.getTeamName(),
                model.getCountry(),
                model.getCode(),
                model.getFounded(),
                model.getLogoPath()
        );
    }

    public static void applyChanges(Team model, TeamUpdateDTO dto) {
        model.setTeamName(dto.getTeamName());
        model.setCountry(dto.getCountry());
        model.setCode(dto.getCode());
        model.setFounded(dto.getFounded());
        model.setLogoPath(dto.getLogoPath());
    }

    // endregion Public Methods

}
