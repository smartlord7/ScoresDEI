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

package Main.BusinessLayer.Player;

import Main.BusinessLayer.Player.DTO.PlayerCreateDTO;
import Main.BusinessLayer.Player.DTO.PlayerListDTO;
import Main.BusinessLayer.Player.Import.PlayerSportsAPIImport;
import Main.BusinessLayer.Player.DTO.PlayerUpdateDTO;
import Main.DataLayer.Enum.PlayerPositionEnum;
import Main.DataLayer.Model.Player;
import Main.DataLayer.Model.Team;
import Main.DataLayer.Repository.TeamRepository;
import com.google.gson.internal.LinkedTreeMap;

public class PlayerTranslator {

    // region Public Methods

    public static Player toModel(PlayerSportsAPIImport dto,
                                 TeamRepository teams) {
        PlayerSportsAPIImport.Player p = dto.getPlayer();
        LinkedTreeMap<String, LinkedTreeMap<String, String>> statistics =
                (LinkedTreeMap<String, LinkedTreeMap<String, String>>) dto.getStatistics().get(0);
        String teamName = statistics.get("team").get("name");
        PlayerPositionEnum position = PlayerPositionEnum.fromString(statistics.get("games").get("position"));
        String heightStr = p.getHeight();
        String weightStr = p.getWeight();
        Double height = null;
        Double weight = null;

        if (heightStr != null) {
            height = Double.parseDouble(heightStr.replaceAll("[^0-9]", ""));
        }

        if (weightStr != null) {
            weight = Double.parseDouble(weightStr.replaceAll("[^0-9]", ""));
        }

        Player model = new Player(
                p.getName(),
                p.getFirstname(),
                p.getLastname(),
                p.getBirth().getDate(),
                position,
                p.getNationality(),
                height,
                weight
        );

        Team team = teams.getFirstByTeamName(teamName);
        if (team != null) {
            model.setTeam(team);
            team.getPlayer().add(model);
        }

        model.setImported(true);

        return model;
    }

    public static PlayerListDTO toListDTO(Player model) {
        Team t = model.getTeam();
        Long teamId = t != null ? t.getId() : null;
        String teamName = t != null ? t.getTeamName() : null;

        return new PlayerListDTO(
                model.getId(),
                model.getPlayerName(),
                model.getPosition(),
                teamId,
                teamName,
                model.getNationality()
        );
    }

    public static PlayerUpdateDTO toUpdateDTO(Player model) {
        Team t = model.getTeam();
        Long teamId = t != null ? t.getId() : null;
        String teamName = t != null ? t.getTeamName() : null;

        return new PlayerUpdateDTO(
                model.getId(),
                model.getPlayerName(),
                model.getPosition(),
                model.getGoals(),
                teamId,
                teamName,
                model.getNationality()
        );
    }

    public static PlayerUpdateDTO toUpdateDTO_(Player model) {
        Team t = model.getTeam();
        Long teamId = t != null ? t.getId() : null;
        String teamName = t != null ? t.getTeamName() : null;

        return new PlayerUpdateDTO(
                model.getId(),
                model.getPlayerName(),
                model.getBirthDate(),
                model.getPosition(),
                teamId,
                teamName,
                model.getFirstName(),
                model.getLastName(),
                model.getNationality(),
                model.getHeight(),
                model.getWeight()
        );
    }

    public static PlayerUpdateDTO toUpdateDTO(long id) {
        return new PlayerUpdateDTO(
                id
        );
    }

    public static Player toModel(PlayerCreateDTO dto) {
        Player p = new Player(
                dto.getPlayerName(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getBirthDate(),
                dto.getPosition(),
                dto.getNationality(),
                dto.getHeight(),
                dto.getWeight()
        );

        p.setImported(false);

        return p;
    }

    public static void applyChanges(Player model, PlayerUpdateDTO dto) {
        model.setPosition(dto.getPosition());
    }

    // endregion Public Methods

}
