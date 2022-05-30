package BusinessLayer.Team;

import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import DataLayer.Model.Team;
import DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TeamWriter {
    @Autowired
    private TeamRepository teams;

    @Transactional
    public TeamCreateDTO create(TeamCreateDTO dto) {
        Team t;

        t = TeamTranslator.toModel(dto);
        teams.save(t);

        dto.setId(t.getId());

        return dto;
    }

    @Transactional
    public TeamUpdateDTO deleteById(long id) {
        teams.deleteById(id);
        return TeamTranslator.toUpdateDTO(id);
    }
}
