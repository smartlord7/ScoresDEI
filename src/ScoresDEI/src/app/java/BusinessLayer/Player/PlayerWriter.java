package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;
import DataLayer.Repository.PlayerRepository;
import DataLayer.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerWriter {
    @Autowired
    private PlayerRepository players;

    @Autowired
    private TeamRepository teams;

    @Transactional
    public PlayerCreateDTO create(PlayerCreateDTO dto) {
        dto.setTeam(teams.getById(dto.getTeamId()));
        Player p = PlayerConverter.toModel(dto);
        p.getTeam().getPlayer().add(p);
        players.save(p);
        dto.setId(p.getId());

        return dto;
    }

    @Transactional
    public PlayerUpdateDTO deleteById(long id) {
        players.deleteById(id);

        return PlayerConverter.toUpdateDTO(id);
    }
}
