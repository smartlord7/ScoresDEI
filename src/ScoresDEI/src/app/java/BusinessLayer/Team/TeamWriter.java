package BusinessLayer.Team;

import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import DataLayer.Model.Attachment;
import DataLayer.Model.Team;
import DataLayer.Repository.AttachmentRepository;
import DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TeamWriter {
    @Autowired
    private TeamRepository teams;

    @Autowired
    private AttachmentRepository attachments;

    @Transactional
    public TeamCreateDTO create(TeamCreateDTO dto) {
        Team t;
        Attachment a;

        t = TeamTranslator.toModel(dto);
        a = attachments.getById(dto.getLogoId());
        t.setLogo(a);
        teams.save(t);

        dto.setId(t.getId());

        return dto;
    }

    @Transactional
    public TeamUpdateDTO deleteById(long id) {
        teams.deleteById(id);
        return TeamTranslator.toUpdateDTO(id);
    }

    @Transactional
    public TeamUpdateDTO update(TeamUpdateDTO dto) {
       Team t;
       Attachment a;

       t = teams.getById(dto.getId());
       TeamTranslator.applyChanges(t, dto);
       a = attachments.getById(dto.getLogoId());
       t.setLogo(a);

       teams.save(t);

       return dto;
    }
}
