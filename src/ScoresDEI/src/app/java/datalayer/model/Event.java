package datalayer.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="eventId", updatable = false, nullable = false)
    private Long id;

    @Column(insertable = false, updatable = false,  columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurrenceTime;

    @Column(length = 4096)
    private String Description;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
