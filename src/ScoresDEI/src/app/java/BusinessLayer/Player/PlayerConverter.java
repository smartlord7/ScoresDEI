package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;

public class PlayerConverter {
    public static PlayerUpdateDTO toUpdateDTO(Player model) {
        return new PlayerUpdateDTO(
                model.getPlayerName(),
                model.getPosition(),
                model.getGoals()
        );
    }

    public static Player toModel(PlayerCreateDTO dto) {
        return new Player(
                dto.getPlayerName(),
                dto.getBirthDate(),
                dto.getPosition()
        );
    }
}
