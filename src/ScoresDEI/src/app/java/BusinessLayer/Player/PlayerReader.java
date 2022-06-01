package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerListDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;
import DataLayer.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerReader {

    // region Private Properties

    @Autowired
    private PlayerRepository players;

    // endregion Private Properties

    // region Public Methods

    public List<PlayerListDTO> getAll() {
        return players.findAll()
                .stream()
                .map(PlayerTranslator::toListDTO)
                .collect(Collectors.toList());
    }

    public PlayerUpdateDTO getById(long id) {
        Player p = players.getById(id);

        return PlayerTranslator.toUpdateDTO_(p);
    }

    public PlayerUpdateDTO getBestScorer() {
        List<Object>[] results = players.getBestScorer();
        Player p = (Player) results[0].get(0);
        long goals = (long) results[0].get(1);
        p.setGoals(goals);

        return PlayerTranslator.toUpdateDTO(p);
    }

    // endregion Public Methods

}
