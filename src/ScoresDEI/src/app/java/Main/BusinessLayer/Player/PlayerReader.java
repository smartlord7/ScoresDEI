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

package Main.BusinessLayer.Player;

import Main.BusinessLayer.Player.DTO.PlayerListDTO;
import Main.BusinessLayer.Player.DTO.PlayerUpdateDTO;
import Main.DataLayer.Model.Player;
import Main.DataLayer.Repository.PlayerRepository;
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

        if (results.length == 0) {
            return new PlayerUpdateDTO();
        }

        Player p = (Player) results[0].get(0);
        long goals = (long) results[0].get(1);
        p.setGoals(goals);

        return PlayerTranslator.toUpdateDTO(p);
    }

    // endregion Public Methods

}
