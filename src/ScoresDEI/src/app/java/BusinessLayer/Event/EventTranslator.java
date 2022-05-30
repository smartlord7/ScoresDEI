package BusinessLayer.Event;

import BusinessLayer.Event.DTO.EventCreateDTO;
import BusinessLayer.Event.DTO.EventListDTO;
import DataLayer.Enum.EventTypeEnum;
import DataLayer.Model.*;

import java.sql.Timestamp;

public class EventTranslator {
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

    public static EventListDTO toListDTO(Event model) {
        return new EventListDTO(model.getId(),
                getEventType(model),
                Timestamp.from(model.getOccurrenceTime().toInstant()));
    }

    public static Event toModel(EventCreateDTO dto) {
        EventTypeEnum type = dto.getEventType();

        if (type == EventTypeEnum.GOAL) {
            EventGoal e = new EventGoal(
                    dto.getOccurrenceTime(),
                    dto.getDescription()
            );
            e.setPlayer(dto.getPlayer());

            return e;
        } else if (type == EventTypeEnum.RED_CARD) {
            EventRedCard e = new EventRedCard(
                    dto.getOccurrenceTime(),
                    dto.getDescription()
            );
            e.setPlayer(dto.getPlayer());

            return e;
        } else if (type == EventTypeEnum.YELLOW_CARD) {
            EventYellowCard e = new EventYellowCard(
                    dto.getOccurrenceTime(),
                    dto.getDescription()
            );
            e.setPlayer(dto.getPlayer());

            return e;
        } else {
            return new Event(
                    dto.getOccurrenceTime(),
                    dto.getDescription()
            );
        }
    }
}
