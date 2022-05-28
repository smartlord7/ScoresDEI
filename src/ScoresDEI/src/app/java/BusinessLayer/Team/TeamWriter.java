package BusinessLayer.Team;

import BusinessLayer.Base.BaseEntityWriter;
import DataLayer.Model.Team;
import DataLayer.Repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamWriter extends BaseEntityWriter<TeamCreateDTO,
        TeamUpdateDTO,
        Team,
        TeamRepository> {
}
