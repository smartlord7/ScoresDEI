package BusinessLayer.Game.DTO;

import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;

import java.util.Date;
import java.util.StringJoiner;

public class GameUpdateDTO implements BaseEntityUpdateDTO {
    private Long id;
    private String place;
    private Date startTime;
    private Date endTime;
    private Long teamAId;
    private String teamAName;
    private Long teamBId;
    private String teamBName;

    public GameUpdateDTO(Long id) {
        this.id = id;
    }

    public GameUpdateDTO(Long id, String place, Date startTime, Date endTime, Long teamAId, Long teamBId) {
        this.id = id;
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
    }

    public GameUpdateDTO(Long id, String place, Date startTime, Date endTime, Long teamAId, String teamAName, Long teamBId, String teamBName) {
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teamAId = teamAId;
        this.teamAName = teamAName;
        this.teamBId = teamBId;
        this.teamBName = teamBName;
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

    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Long teamBId) {
        this.teamBId = teamBId;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GameListDTO.class.getSimpleName() + "[", "]")
                .add("place='" + place + "'")
                .add("startTime=" + startTime)
                .add("endTime=" + endTime)
                .add("teamAId=" + teamAId)
                .add("teamAName='" + teamAName + "'")
                .add("teamBId=" + teamBId)
                .add("teamBName='" + teamBName + "'")
                .toString();
    }

}
