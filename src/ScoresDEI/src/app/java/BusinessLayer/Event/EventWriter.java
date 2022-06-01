package BusinessLayer.Event;

import BusinessLayer.Event.DTO.EventCreateDTO;
import BusinessLayer.Event.DTO.EventUpdateDTO;
import DataLayer.Enum.EventTypeEnum;
import DataLayer.Model.*;
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
        if (dto.getPlayerId() != null) {
            dto.setPlayer(players.getById(dto.getPlayerId()));
        }

        Event e = EventTranslator.toModel(dto);
        e.setGame(games.getById(dto.getGameId()));
        e.setApproved(true); // admin approval for events is not yet implemented
        EventTypeEnum type = dto.getEventType();

        Game g = e.getGame();
        if (type == EventTypeEnum.GOAL && e.isApproved()) {
            Team tA = g.getTeamA();
            Team tB = g.getTeamB();
            Player p = dto.getPlayer();

            if (tA.getPlayer().contains(p)) {
                g.setScoreA(g.getScoreA() + 1);
            } else if (tB.getPlayer().contains(p))  {
                g.setScoreB(g.getScoreB() + 1);
            }
        }

        if (type == EventTypeEnum.START_GAME) {
            g.setEventStartGame((EventStartGame) e);
        } else if (type == EventTypeEnum.END_GAME) {
            g.setEventEndGame((EventEndGame) e);
        }

        events.save(e);
        dto.setId(e.getId());

        return dto;
    }

    // endregion Public Methods


}
