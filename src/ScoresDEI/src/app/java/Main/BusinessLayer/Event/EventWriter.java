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

package Main.BusinessLayer.Event;

import Main.BusinessLayer.Event.DTO.EventCreateDTO;
import Main.DataLayer.Enum.EventTypeEnum;
import Main.DataLayer.Repository.EventRepository;
import Main.DataLayer.Repository.GameRepository;
import Main.DataLayer.Repository.PlayerRepository;
import Main.DataLayer.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

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
    public EventCreateDTO create(EventCreateDTO dto) throws ParseException {
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
