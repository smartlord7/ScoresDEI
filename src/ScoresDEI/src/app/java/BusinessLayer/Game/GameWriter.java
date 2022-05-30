package BusinessLayer.Game;

import BusinessLayer.Game.DTO.GameCreateDTO;
import BusinessLayer.Game.DTO.GameUpdateDTO;
import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import DataLayer.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GameWriter {
    @Autowired
    private GameRepository teams;

    @Transactional
    public GameCreateDTO create(TeamCreateDTO dto) {
        return null;
    }

    @Transactional
    public GameUpdateDTO deleteById(long id) {
        return null;
    }

    @Transactional
    public TeamUpdateDTO update(TeamUpdateDTO dto) {
      return dto;
    }
}
