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

package BusinessLayer.Team;

import BusinessLayer.Attachment.DTO.AttachmentUpdateDTO;
import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamListDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import BusinessLayer.Team.Import.TeamSportsAPIImport;
import DataLayer.Enum.StorageTypeEnum;
import DataLayer.Model.Attachment;
import DataLayer.Model.Team;

public class TeamTranslator {

    // region Public Methods

    public static Team toModel(TeamSportsAPIImport dto) {
        Team t = new Team(
                dto.getName(),
                dto.getCountry(),
                dto.getCode(),
                dto.getFounded()
        );
        t.setImported(true);

        return t;
    }

    public static Team toModel(TeamCreateDTO dto) {
        return new Team(
                dto.getTeamName(),
                dto.getCountry(),
                dto.getCode(),
                dto.getFounded()
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
        Attachment logo = model.getLogo();

        StorageTypeEnum storageTypeEnum = null;
        String path = null;

        if (logo != null) {
            storageTypeEnum = logo.getStorageType();
            path = logo.getPath();
        }

        return new TeamUpdateDTO(
                model.getId(),
                model.getTeamName(),
                new AttachmentUpdateDTO(
                        storageTypeEnum,
                        path
                )
        );
    }

    public static void applyChanges(Team model, TeamUpdateDTO dto) {
        model.setTeamName(dto.getTeamName());
        model.setCountry(dto.getCountry());
        model.setCode(dto.getCode());
        model.setFounded(dto.getFounded());
    }

    // endregion Public Methods

}
