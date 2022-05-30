package BusinessLayer.Game;

import BusinessLayer.Game.DTO.GameCreateDTO;
import BusinessLayer.Game.DTO.GameListDTO;
import BusinessLayer.Game.DTO.GameUpdateDTO;
import DataLayer.Model.Game;
import DataLayer.Model.Team;

public class GameTranslator {
    public static Game toModel(GameCreateDTO dto) {
        return new Game(dto.getPlace(),
                dto.getStartTime(),
                dto.getEndTime());
    }

    public static GameListDTO toListDTO(Game model) {
        return new GameListDTO(model.getPlace(),
                model.getStartTime(),
                model.getEndTime(),
                model.getTeamA().getId(),
                model.getTeamA().getTeamName(),
                model.getTeamB().getId(),
                model.getTeamB().getTeamName());
    }

    public static GameUpdateDTO toUpdateDTO(Game model) {
        return new GameUpdateDTO(model.getId(),
                model.getPlace(),
                model.getStartTime(),
                model.getEndTime(),
                model.getTeamA().getId(),
                model.getTeamA().getTeamName(),
                model.getTeamB().getId(),
                model.getTeamB().getTeamName());
    }

    public static GameUpdateDTO toUpdateDTO(Long id) {
        return new GameUpdateDTO(id);
    }

    public static void applyChanges(Game model, GameUpdateDTO dto) {
        model.setPlace(dto.getPlace());
        model.setStartTime(dto.getStartTime());
        model.setEndTime(dto.getEndTime());
    }
}
