/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

package Main.BusinessLayer.Game;

import Main.BusinessLayer.Event.DTO.EventListDTO;
import Main.BusinessLayer.Event.EventTranslator;
import Main.BusinessLayer.Game.DTO.GameListDTO;
import Main.BusinessLayer.Game.DTO.GameUpdateDTO;
import Main.DataLayer.Model.Event;
import Main.DataLayer.Model.Game;
import Main.DataLayer.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class GameReader {

    // region Private Properties

    @Autowired
    private GameRepository games;

    // endregion Private Properties

    // region Public Methods

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

    // endregion Public Methods
}
