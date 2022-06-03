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

package Main.BusinessLayer.Game;

import Main.BusinessLayer.Game.DTO.GameCreateDTO;
import Main.BusinessLayer.Game.DTO.GameListDTO;
import Main.BusinessLayer.Game.DTO.GameUpdateDTO;
import Main.DataLayer.Model.Game;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameTranslator {

    // region Public Methods

    public static Game toModel(GameCreateDTO dto) throws ParseException {
        String startTimeStr = dto.getStartTime().replace("T", " ");
        String endTimeStr = dto.getStartTime().replace("T", " ");
        Date startTime = new SimpleDateFormat("MM-yyyy-dd HH:mm").parse(startTimeStr);
        Date endTime = new SimpleDateFormat("MM-yyyy-dd HH:mm").parse(endTimeStr);

        return new Game(
                dto.getPlace(),
                startTime,
                endTime);
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
        return new GameUpdateDTO(
                model.getId(),
                model.getPlace(),
                model.getStartTime().toString(),
                model.getEndTime().toString(),
                model.getTeamA().getId(),
                model.getTeamA().getTeamName(),
                model.getTeamB().getId(),
                model.getTeamB().getTeamName(),
                model.getScoreA(),
                model.getScoreB()
        );
    }

    public static GameUpdateDTO toUpdateDTO(Long id) {
        return new GameUpdateDTO(id);
    }

    public static void applyChanges(Game model, GameUpdateDTO dto) throws ParseException {
        String startTimeStr = dto.getStartTime().replace("T", " ");
        String endTimeStr = dto.getStartTime().replace("T", " ");
        Date startTime = new SimpleDateFormat("MM-yyyy-dd HH:mm").parse(startTimeStr);
        Date endTime = new SimpleDateFormat("MM-yyyy-dd HH:mm").parse(endTimeStr);
        model.setPlace(dto.getPlace());
        model.setStartTime(startTime);
        model.setEndTime(endTime);
    }

    // endregion Public Methods

}
