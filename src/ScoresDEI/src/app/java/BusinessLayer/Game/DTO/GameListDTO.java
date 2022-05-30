package BusinessLayer.Game.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;

import java.util.Date;
import java.util.StringJoiner;

public class GameListDTO implements BaseEntityListDTO {
    private String place;
    private Date startTime;
    private Date endTime;
    private Long teamAId;
    private String teamAName;
    private Long teamBId;
    private String teamBName;

    public GameListDTO(String place, Date startTime, Date endTime, Long teamAId, String teamAName, Long teamBId, String teamBName) {
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
