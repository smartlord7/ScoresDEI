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

package BusinessLayer.Game.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;

import java.util.Date;
import java.util.StringJoiner;

public class GameListDTO implements BaseEntityListDTO {

    // region Private Properties

    private Long id;
    private String place;
    private Date startTime;
    private Date endTime;
    private Long teamAId;
    private String teamAName;
    private Long teamBId;
    private String teamBName;
    private Integer scoreA;
    private Integer scoreB;

    // endregion Private Properties

    // region Constructors


    public GameListDTO() {
    }

    public GameListDTO(Long id, String place, Date startTime, Date endTime, Long teamAId, String teamAName, Long teamBId, String teamBName, Integer scoreA, Integer scoreB) {
        this.id = id;
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teamAId = teamAId;
        this.teamAName = teamAName;
        this.teamBId = teamBId;
        this.teamBName = teamBName;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    // endregion Constructors

    // region Getters and Setters

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

    public Long getId() {
        return id;
    }

    public Integer getScoreA() {
        return scoreA;
    }

    public void setScoreA(Integer scoreA) {
        this.scoreA = scoreA;
    }

    public Integer getScoreB() {
        return scoreB;
    }

    public void setScoreB(Integer scoreB) {
        this.scoreB = scoreB;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GameListDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("place='" + place + "'")
                .add("startTime=" + startTime)
                .add("endTime=" + endTime)
                .add("teamAId=" + teamAId)
                .add("teamAName='" + teamAName + "'")
                .add("teamBId=" + teamBId)
                .add("teamBName='" + teamBName + "'")
                .add("scoreA=" + scoreA)
                .add("scoreB=" + scoreB)
                .toString();
    }

    // endregion Getters and Setters

}
