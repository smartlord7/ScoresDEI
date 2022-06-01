package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerListDTO;
import BusinessLayer.Player.DTO.PlayerSportsAPIImportDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Enum.PlayerPositionEnum;
import DataLayer.Model.Player;
import DataLayer.Model.Team;
import DataLayer.Repository.TeamRepository;
import com.google.gson.internal.LinkedTreeMap;

public class PlayerTranslator {

    // region Public Methods

    public static Player toModel(PlayerSportsAPIImportDTO dto,
                                              TeamRepository teams) {
        PlayerSportsAPIImportDTO.Player p = dto.getPlayer();
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

        Team team = teams.getTeamByTeamName(teamName);
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
                teamName
        );
    }

    public static PlayerUpdateDTO toUpdateDTO(Player model) {
        return new PlayerUpdateDTO(
                model.getId(),
                model.getPlayerName(),
                model.getPosition(),
                model.getGoals()
        );
    }

    public static PlayerUpdateDTO toUpdateDTO_(Player model) {
        Team t = model.getTeam();
        Long teamId = t != null ? t.getId() : null;
        String teamName = t != null ? t.getTeamName() : null;

        return new PlayerUpdateDTO(
                model.getId(),
                model.getPlayerName(),
                model.getPosition(),
                model.getBirthDate(),
                teamId,
                teamName
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
