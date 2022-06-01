package BusinessLayer.Event.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;
import DataLayer.Enum.EventTypeEnum;

import java.sql.Timestamp;
import java.util.Date;
import java.util.StringJoiner;

public class EventListDTO implements BaseEntityListDTO {

    // region Private Properties

    private Long id;
    private EventTypeEnum eventType;
    private Date occurrenceTime;

    // endregion Private Properties

    // region Getters,Setters,Constructors

    public EventListDTO() {
    }

    public EventListDTO(Long id, EventTypeEnum eventType, Date occurrenceTime) {
        this.id = id;
        this.eventType = eventType;
        this.occurrenceTime = occurrenceTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Timestamp occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EventListDTO.class.getSimpleName() + "[", "]")
                .add("eventType=" + eventType)
                .add("occurrenceTime=" + occurrenceTime)
                .toString();
    }

    // endregion Getters,Setters,Constructors

}
