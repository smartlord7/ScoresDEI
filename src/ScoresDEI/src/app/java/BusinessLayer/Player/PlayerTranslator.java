package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;

public class PlayerTranslator {
    public static PlayerUpdateDTO toUpdateDTO(Player model) {
        return new PlayerUpdateDTO(
                model.getId(),
                model.getPlayerName(),
                model.getPosition(),
                model.getGoals()
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
                dto.getPosition(),
                dto.getTeam()
        );
    }

    public static void applyChanges(Player model, PlayerUpdateDTO dto) {
        model.setPosition(dto.getPosition());
    }
}
