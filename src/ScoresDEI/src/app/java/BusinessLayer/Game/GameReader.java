package BusinessLayer.Game;

import BusinessLayer.Game.DTO.GameListDTO;
import BusinessLayer.Team.DTO.TeamListDTO;
import DataLayer.Repository.GameRepository;
import DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameReader {
    @Autowired
    private GameRepository games;

    public List<GameListDTO> readAll() {
        return games.findAll()
                .stream()
                .map(GameTranslator::toListDTO)
                .collect(Collectors.toList());
    }
}
