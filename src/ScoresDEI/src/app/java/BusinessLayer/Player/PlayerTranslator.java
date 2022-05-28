package BusinessLayer.Player;

import BusinessLayer.Base.BaseEntityDTO;
import BusinessLayer.Base.BaseEntityTranslator;
import DataLayer.Model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerTranslator extends BaseEntityTranslator<PlayerCreateDTO,
        PlayerUpdateDTO,
        PlayerListDTO,
        Player> {

    @Override
    public PlayerUpdateDTO toUpdateDTO(Player model) {
        return null;
    }

    @Override
    public PlayerCreateDTO toCreateDTO(Player model) {
        return null;
    }

    @Override
    public PlayerListDTO toListDTO(Player models) {
        return null;
    }

    @Override
    public Player toModel(BaseEntityDTO dto) {
        return null;
    }
}
