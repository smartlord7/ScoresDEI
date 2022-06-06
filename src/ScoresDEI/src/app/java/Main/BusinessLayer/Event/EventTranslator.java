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
import Main.BusinessLayer.Event.DTO.EventListDTO;
import Main.DataLayer.Enum.EventTypeEnum;
import Main.DataLayer.Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventTranslator {

    // region Private Methods

    private static EventTypeEnum getEventType(Event event) {
        Class<? extends Event> clazz = event.getClass();

        if (clazz == EventStartGame.class) {
            return EventTypeEnum.START_GAME;
        } else if (clazz == EventEndGame.class) {
            return EventTypeEnum.END_GAME;
        } else if (clazz == EventInterruptGame.class) {
            return EventTypeEnum.INTERRUPT_GAME;
        } else if (clazz == EventResumeGame.class) {
            return EventTypeEnum.RESUME_GAME;
        } else if (clazz == EventGoal.class) {
            return EventTypeEnum.GOAL;
        } else if (clazz == EventYellowCard.class) {
            return EventTypeEnum.YELLOW_CARD;
        } else {
            return EventTypeEnum.RED_CARD;
        }
    }

    // endregion Private Methods

    // region Public Methods

    public static EventListDTO toListDTO(Event model) {
        return new EventListDTO(
                model.getId(),
                getEventType(model),
                model.getOccurrenceTime(),
                model.isApproved()
        );
    }

    public static Event toModel(EventCreateDTO dto) throws ParseException {
        EventTypeEnum type = dto.getEventType();
        String timeStr = dto.getOccurrenceTime().replace("T", " ");
        Date occurrenceTime = new SimpleDateFormat("MM-yyyy-dd HH:mm").parse(timeStr);

        if (type == EventTypeEnum.GOAL) {
            EventGoal e = new EventGoal(
                    occurrenceTime,
                    dto.getDescription()
            );
            e.setPlayer(dto.getPlayer());

            return e;
        } else if (type == EventTypeEnum.RED_CARD) {
            EventRedCard e = new EventRedCard(
                    occurrenceTime,
                    dto.getDescription()
            );
            e.setPlayer(dto.getPlayer());

            return e;
        } else if (type == EventTypeEnum.YELLOW_CARD) {
            EventYellowCard e = new EventYellowCard(
                    occurrenceTime,
                    dto.getDescription()
            );
            e.setPlayer(dto.getPlayer());

            return e;
        } else if (type == EventTypeEnum.END_GAME){
            return new EventEndGame(
                    occurrenceTime,
                    dto.getDescription()
            );
        } else if (type == EventTypeEnum.START_GAME) {
            return new EventStartGame(
                    occurrenceTime,
                    dto.getDescription()
            );
        } else if (type == EventTypeEnum.INTERRUPT_GAME) {
            return new EventInterruptGame(
                    occurrenceTime,
                    dto.getDescription()
            );
        } else {
            return new EventResumeGame(
                    occurrenceTime,
                    dto.getDescription()
            );
        }
    }

    // endregion Public Methods

}
