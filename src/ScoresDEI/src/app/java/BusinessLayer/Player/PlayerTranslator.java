package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerListDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;
import DataLayer.Model.Team;

public class PlayerTranslator {

    // region Public Methods

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
        return new Player(
                dto.getPlayerName(),
                dto.getBirthDate(),
                dto.getPosition()
        );
    }

    public static void applyChanges(Player model, PlayerUpdateDTO dto) {
        model.setPosition(dto.getPosition());
    }

    // endregion Public Methods

}
