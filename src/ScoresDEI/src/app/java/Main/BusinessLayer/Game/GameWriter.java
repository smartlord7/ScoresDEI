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
import Main.BusinessLayer.Game.DTO.GameUpdateDTO;
import Main.DataLayer.Model.Game;
import Main.DataLayer.Model.Team;
import Main.DataLayer.Repository.GameRepository;
import Main.DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GameWriter {

    // region Private Properties

    @Autowired
    private GameRepository games;

    @Autowired
    private TeamRepository teams;

    // endregion Private Properties

    // region Public Methods

    @Transactional
    public GameCreateDTO create(GameCreateDTO dto) {
        Game g = new Game(dto.getPlace(),
                dto.getStartTime(),
                dto.getEndTime());
        Team tA = teams.getById(dto.getTeamAId());
        Team tB = teams.getById(dto.getTeamBId());
        g.setTeamA(tA);
        g.setTeamB(tB);
        g.setScoreA(0);
        g.setScoreB(0);

        games.save(g);
        dto.setId(g.getId());

        return dto;
    }

    @Transactional
    public GameUpdateDTO deleteById(long id) {
        games.deleteById(id);

        return GameTranslator.toUpdateDTO(id);
    }

    @Transactional
    public GameUpdateDTO update(GameUpdateDTO dto) {
        Game g = games.getById(dto.getId());
        GameTranslator.applyChanges(g, dto);
        g.setTeamA(teams.getById(dto.getTeamAId()));
        g.setTeamB(teams.getById(dto.getTeamBId()));

        games.save(g);

        return dto;
    }

    // endregion Public Methods.

}
