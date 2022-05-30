package BusinessLayer.Game;

import BusinessLayer.Game.DTO.GameCreateDTO;
import BusinessLayer.Game.DTO.GameUpdateDTO;
import BusinessLayer.Team.TeamTranslator;
import DataLayer.Model.Attachment;
import DataLayer.Model.Game;
import DataLayer.Model.Team;
import DataLayer.Repository.GameRepository;
import DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GameWriter {
    @Autowired
    private GameRepository games;

    @Autowired
    private TeamRepository teams;

    @Transactional
    public GameCreateDTO create(GameCreateDTO dto) {
        Game g;
        g = new Game(dto.getPlace(),
                dto.getStartTime(),
                dto.getEndTime());
        g.setTeamA(teams.getById(dto.getTeamAId()));
        g.setTeamB(teams.getById(dto.getTeamBId()));

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
}
