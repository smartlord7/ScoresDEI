package BusinessLayer.Event;

import BusinessLayer.Event.DTO.EventCreateDTO;
import DataLayer.Enum.EventTypeEnum;
import DataLayer.Model.Event;
import DataLayer.Model.EventGoal;
import DataLayer.Model.EventRedCard;
import DataLayer.Model.EventYellowCard;
import DataLayer.Repository.EventRepository;
import DataLayer.Repository.GameRepository;
import DataLayer.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class EventWriter {
    @Autowired
    private EventRepository events;

    @Autowired
    private GameRepository games;

    @Autowired
    private PlayerRepository players;

    @Transactional
    public EventCreateDTO create(EventCreateDTO dto) {
        Event e = EventTranslator.toModel(dto);
        e.setGame(games.getById(dto.getGameId()));
        EventTypeEnum type = dto.getEventType();

        events.save(e);
        dto.setId(e.getId());

        return dto;
    }
}
