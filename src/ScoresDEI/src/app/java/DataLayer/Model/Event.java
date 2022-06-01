package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Event extends AbstractAuditable<User, Long> implements BaseEntityModel {

    // region Private Properties

    @Column(insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurrenceTime;

    @Column(length = 4096)
    private String description;

    @ManyToOne
    private Game game;

    private boolean approved;

    // endregion Private Properties

    // region Getters,Setters and Constructors

    public Event() {
    }

    public Event(Date occurrenceTime, String description) {
        this.occurrenceTime = occurrenceTime;
        this.description = description;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // endregion Getters,Setters and Constructors

}
