package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import DataLayer.Model.Player;
import DataLayer.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerWriter {
    @Autowired
    private PlayerRepository players;

    public PlayerCreateDTO create(PlayerCreateDTO dto) {
        Player p = PlayerConverter.toModel(dto);
        players.save(p);
        dto.setId(p.getId());

        return dto;
    }
}
