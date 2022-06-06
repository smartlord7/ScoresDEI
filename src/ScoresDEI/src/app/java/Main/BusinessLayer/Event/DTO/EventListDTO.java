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

package Main.BusinessLayer.Event.DTO;

import Main.BusinessLayer.Base.DTO.BaseEntityListDTO;
import Main.DataLayer.Enum.EventTypeEnum;

import java.sql.Timestamp;
import java.util.Date;
import java.util.StringJoiner;

public class EventListDTO implements BaseEntityListDTO {

    // region Private Properties

    private Long id;
    private EventTypeEnum eventType;
    private Date occurrenceTime;
    private Boolean approved;
    // endregion Private Properties

    // region Constructors

    public EventListDTO() {
    }

    public EventListDTO(Long id, EventTypeEnum eventType, Date occurrenceTime, Boolean approved) {
        this.id = id;
        this.eventType = eventType;
        this.occurrenceTime = occurrenceTime;
        this.approved = approved;
    }

    // endregion Constructors

    // region Getters and Setters

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

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EventListDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("eventType=" + eventType)
                .add("occurrenceTime=" + occurrenceTime)
                .add("approved=" + approved)
                .toString();
    }

    // endregion Getters and Setters

}
