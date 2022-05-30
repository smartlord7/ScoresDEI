package BusinessLayer.Game;

import BusinessLayer.Event.DTO.EventListDTO;
import BusinessLayer.Event.EventReader;
import BusinessLayer.Event.EventTranslator;
import BusinessLayer.Game.DTO.GameListDTO;
import BusinessLayer.Game.DTO.GameUpdateDTO;
import DataLayer.Model.Event;
import DataLayer.Model.Game;
import DataLayer.Repository.EventRepository;
import DataLayer.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class GameReader {
    @Autowired
    private GameRepository games;

    public List<GameListDTO> getAll() {
        return games.findAll()
                .stream()
                .map(GameTranslator::toListDTO)
                .toList();
    }

    public GameUpdateDTO getById(long id) {
        Game model = games.getById(id);
        GameUpdateDTO dto = GameTranslator.toUpdateDTO(model);
        dto.setEvents(getEvents(id));

        return dto;
    }

    public List<EventListDTO> getEvents(long id) {
        var game = games.getById(id);
        List<Event> events = new ArrayList<Event>();
        events.add(game.getEventStartGame());
        events.add(game.getEventEndGame());
        events.addAll(game.getEventInterruptGame());
        events.addAll(game.getEventResumeGame());
        events.addAll(game.getEventGoal());
        events.addAll(game.getEventYellowCard());
        events.addAll(game.getEventRedCard());

        return events.stream()
                .filter(Objects::nonNull)
                .map(EventTranslator::toListDTO).sorted(Comparator.comparing(EventListDTO::getOccurrenceTime))
                .toList();
    }
}
