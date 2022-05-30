package BusinessLayer.Team;

import BusinessLayer.Team.DTO.TeamListDTO;
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
                .map(team -> new TeamListDTO(team.getTeamName()))
                .collect(Collectors.toList());
    }
}
