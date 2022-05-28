package BusinessLayer.Player;

import BusinessLayer.Base.BaseEntityWriter;
import DataLayer.Model.Player;
import DataLayer.Repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerWriter extends BaseEntityWriter<PlayerCreateDTO,
        PlayerUpdateDTO,
        Player,
        PlayerRepository> {
}
