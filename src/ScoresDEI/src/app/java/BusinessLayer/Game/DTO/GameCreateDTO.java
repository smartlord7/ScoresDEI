package BusinessLayer.Game.DTO;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;

import java.util.Date;
import java.util.StringJoiner;

public class GameCreateDTO implements BaseEntityCreateDTO {
    private Long id;
    private String place;
    private Date startTime;
    private Date endTime;
    private Long teamAId;
    private Long teamBId;

    public GameCreateDTO(String place, Date startTime, Date endTime, Long teamAId, Long teamBId) {
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
    }

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

    public Long getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Long teamAId) {
        this.teamAId = teamAId;
    }

    public Long getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Long teamBId) {
        this.teamBId = teamBId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GameCreateDTO.class.getSimpleName() + "[", "]")
                .add("place='" + place + "'")
                .add("startTime=" + startTime)
                .add("endTime=" + endTime)
                .add("teamAId=" + teamAId)
                .add("teamBId=" + teamBId)
                .toString();
    }
}
