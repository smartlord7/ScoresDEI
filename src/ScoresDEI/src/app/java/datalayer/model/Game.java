package datalayer.model;

import javax.persistence.*;
import java.util.Date;

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="gameId", updatable = false, nullable = false)
    private Long id;

    @Column(length = 1024, nullable = false)
    private String place;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
