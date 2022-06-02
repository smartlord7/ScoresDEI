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

package BusinessLayer.Game;

import BusinessLayer.Game.DTO.GameCreateDTO;
import BusinessLayer.Game.DTO.GameListDTO;
import BusinessLayer.Game.DTO.GameUpdateDTO;
import DataLayer.Model.Game;

public class GameTranslator {

    // region Public Methods

    public static Game toModel(GameCreateDTO dto) {
        return new Game(dto.getPlace(),
                dto.getStartTime(),
                dto.getEndTime());
    }

    public static GameListDTO toListDTO(Game model) {
        return new GameListDTO(
                model.getId(),
                model.getPlace(),
                model.getStartTime(),
                model.getEndTime(),
                model.getTeamA().getId(),
                model.getTeamA().getTeamName(),
                model.getTeamB().getId(),
                model.getTeamB().getTeamName(),
                model.getScoreA(),
                model.getScoreB()
        );
    }

    public static GameUpdateDTO toUpdateDTO(Game model) {
        return new GameUpdateDTO(model.getId(),
                model.getPlace(),
                model.getStartTime(),
                model.getEndTime(),
                model.getTeamA().getId(),
                model.getTeamA().getTeamName(),
                model.getTeamB().getId(),
                model.getTeamB().getTeamName(),
                model.getScoreA(),
                model.getScoreB());
    }

    public static GameUpdateDTO toUpdateDTO(Long id) {
        return new GameUpdateDTO(id);
    }

    public static void applyChanges(Game model, GameUpdateDTO dto) {
        model.setPlace(dto.getPlace());
        model.setStartTime(dto.getStartTime());
        model.setEndTime(dto.getEndTime());
    }

    // endregion Public Methods

}
