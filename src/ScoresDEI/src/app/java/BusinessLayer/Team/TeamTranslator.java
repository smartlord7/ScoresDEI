package BusinessLayer.Team;

import BusinessLayer.Base.BaseEntityDTO;
import BusinessLayer.Base.BaseEntityTranslator;
import DataLayer.Model.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamTranslator extends BaseEntityTranslator<TeamCreateDTO,
        TeamUpdateDTO,
        TeamListDTO,
        Team> {

    @Override
    public TeamUpdateDTO toUpdateDTO(Team model) {
        return null;
    }

    @Override
    public TeamCreateDTO toCreateDTO(Team model) {
        return null;
    }

    @Override
    public TeamListDTO toListDTO(Team models) {
        return null;
    }

    @Override
    public Team toModel(BaseEntityDTO dto) {
        return null;
    }
}
