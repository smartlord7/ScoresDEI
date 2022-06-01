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

    // region Private Properties

    @Autowired
    private TeamRepository teams;

    @Autowired
    private AttachmentRepository attachments;

    // endregion Private Properties

    // region Public Methods

    @Transactional
    public TeamCreateDTO create(TeamCreateDTO dto) {
        Team t;

        t = TeamTranslator.toModel(dto);
        if (dto.getLogoId() != null) {
            Attachment a = attachments.getById(dto.getLogoId());
            t.setLogo(a);
        }
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

       t = teams.getById(dto.getId());
        if (dto.getLogoId() != null) {
            TeamTranslator.applyChanges(t, dto);
            Attachment a = attachments.getById(dto.getLogoId());
            t.setLogo(a);
        }

       teams.save(t);

       return dto;
    }

    // endregion Public Methods

}
