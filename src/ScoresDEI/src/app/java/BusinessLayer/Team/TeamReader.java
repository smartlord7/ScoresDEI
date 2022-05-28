package BusinessLayer.Team;

import BusinessLayer.Base.BaseEntityReader;
import DataLayer.Model.Team;
import DataLayer.Repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamReader extends BaseEntityReader<TeamListDTO,
        TeamUpdateDTO,
        Team,
        TeamRepository> {
}
