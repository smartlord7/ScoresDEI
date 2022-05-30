package BusinessLayer.Team;

import BusinessLayer.Team.DTO.TeamListDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import DataLayer.Model.Team;
import DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamReader {
    @Autowired
    private TeamRepository teams;

    public List<TeamListDTO> readAll() {
        return teams.findAll()
                .stream()
                .map(TeamTranslator::toListDTO)
                .collect(Collectors.toList());
    }

    public TeamUpdateDTO readById(long id) {
        Team t;
        t = teams.findById(id).get();
        return TeamTranslator.toUpdateDTO(t);
    }
}
