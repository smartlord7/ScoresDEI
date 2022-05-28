package BusinessLayer.Player;

import BusinessLayer.Base.BaseEntityReader;
import DataLayer.Model.Player;
import DataLayer.Repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerReader extends BaseEntityReader<PlayerListDTO,
        PlayerUpdateDTO,
        Player,
        PlayerRepository> {
}
