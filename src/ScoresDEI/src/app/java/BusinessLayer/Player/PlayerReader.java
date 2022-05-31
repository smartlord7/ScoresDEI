package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;
import DataLayer.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerReader {
    @Autowired
    private PlayerRepository players;

    public PlayerUpdateDTO getBestScorer() {
        List<Object>[] results = players.getBestScorer();
        Player p = (Player) results[0].get(0);
        long goals = (long) results[0].get(1);
        p.setGoals(goals);

        return PlayerTranslator.toUpdateDTO(p);
    }
}
