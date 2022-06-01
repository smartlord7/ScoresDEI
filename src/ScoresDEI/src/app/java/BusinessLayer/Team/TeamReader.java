package BusinessLayer.Team;

import BusinessLayer.Team.DTO.TeamListDTO;
import BusinessLayer.Team.DTO.TeamListDetailedDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import DataLayer.Model.Team;
import DataLayer.Repository.TeamRepository;
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

    // endregion Private Properties

    // region Public Methods

    public List<TeamListDTO> getAll() {
        return teams.findAll()
                .stream()
                .map(TeamTranslator::toListDTO)
                .collect(Collectors.toList());
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
        Team t;

        t = teams.getById(id);

        return TeamTranslator.toUpdateDTO(t);
    }

    // endregion Public Methods

}
