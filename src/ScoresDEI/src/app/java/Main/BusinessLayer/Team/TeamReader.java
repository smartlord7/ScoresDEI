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

package Main.BusinessLayer.Team;

import Main.BusinessLayer.Player.PlayerTranslator;
import Main.BusinessLayer.Team.DTO.TeamListDTO;
import Main.BusinessLayer.Team.DTO.TeamListDetailedDTO;
import Main.BusinessLayer.Team.DTO.TeamUpdateDTO;
import Main.DataLayer.Model.Team;
import Main.DataLayer.Repository.PlayerRepository;
import Main.DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamReader {

    // region Private Properties

    @Autowired
    private TeamRepository teams;

    @Autowired
    private PlayerRepository players;

    // endregion Private Properties

    // region Public Methods

    public List<TeamListDTO> getAll() {
        return teams.findAll()
                .stream()
                .map(TeamTranslator::toListDTO)
                .toList();
    }

    public List<TeamListDetailedDTO> getAllDetailed() {
        return Arrays.stream(teams.getAllDetailed())
                .map(cols -> new TeamListDetailedDTO(
                    (long) cols.get(0),
                    (String) cols.get(1),
                    (long) cols.get(2),
                    (long) cols.get(3),
                    (long) cols.get(4),
                    (long) cols.get(5)
        )).toList();
    }

    public TeamUpdateDTO getById(long id) {
        Team t = teams.getById(id);
        TeamUpdateDTO dto = TeamTranslator.toUpdateDTO(t);
        dto.setPlayers(players.getByTeam_Id(id).stream().map(PlayerTranslator::toListDTO).toList());

        return dto;
    }

    // endregion Public Methods

}
