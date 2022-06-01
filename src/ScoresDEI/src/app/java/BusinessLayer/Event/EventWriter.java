package BusinessLayer.Event;

import BusinessLayer.Event.DTO.EventCreateDTO;
import BusinessLayer.Event.DTO.EventUpdateDTO;
import DataLayer.Model.Event;
import DataLayer.Repository.EventRepository;
import DataLayer.Repository.GameRepository;
import DataLayer.Repository.PlayerRepository;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventWriter {

    // region Private Properties

    @Autowired
    private EventRepository events;

    @Autowired
    private GameRepository games;

    @Autowired
    private PlayerRepository players;

    // endregion Private Properties

    // region Public Methods

    @Transactional
    public EventCreateDTO create(EventCreateDTO dto) {
        dto.setPlayer(players.getById(dto.getPlayerId()));
        Event e = EventTranslator.toModel(dto);
        e.setGame(games.getById(dto.getGameId()));
        events.save(e);
        dto.setId(e.getId());

        return dto;
    }

    @Transactional
    public EventUpdateDTO toggleApprove(long id) {
        throw new NotYetImplementedException();
    }

    // endregion Public Methods


}
