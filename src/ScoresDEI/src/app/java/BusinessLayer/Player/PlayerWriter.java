package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;
import DataLayer.Model.Team;
import DataLayer.Repository.PlayerRepository;
import DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerWriter {

    // region Private Properties

    @Autowired
    private PlayerRepository players;

    @Autowired
    private TeamRepository teams;

    // endregion Private Properties

    // region Public Methods

    @Transactional
    public PlayerCreateDTO create(PlayerCreateDTO dto) {
        dto.setTeam(teams.getById(dto.getTeamId()));
        Player p = PlayerTranslator.toModel(dto);
        p.getTeam().getPlayer().add(p);
        players.save(p);
        dto.setId(p.getId());

        return dto;
    }

    @Transactional
    public PlayerUpdateDTO deleteById(long id) {
        players.deleteById(id);

        return PlayerTranslator.toUpdateDTO(id);
    }

    @Transactional
    public PlayerUpdateDTO update(PlayerUpdateDTO dto) {
        Player p = players.getById(dto.getId());
        PlayerTranslator.applyChanges(p, dto);
        Team t = p.getTeam();

        if (!dto.getTeamId().equals(t.getId())) {
            t.getPlayer().remove(p);
            Team t2 = teams.getById(dto.getTeamId());
            p.setTeam(t2);
            t2.getPlayer().add(p);
        }

        players.save(p);

        return dto;
    }

    // endregion Public Methods

}
