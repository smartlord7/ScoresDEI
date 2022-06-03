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

package Main.BusinessLayer.Game.DTO;

import Main.BusinessLayer.Base.DTO.BaseEntityCreateDTO;

import java.util.Date;
import java.util.StringJoiner;

public class GameCreateDTO implements BaseEntityCreateDTO {

    // region Private Properties

    private Long id;
    private String place;
    private String startTime;
    private String endTime;
    private Long teamAId;
    private Long teamBId;

    // endregion Private Properties

    // region Constructors

    public GameCreateDTO() {
    }

    public GameCreateDTO(String place, String startTime, String endTime, Long teamAId, Long teamBId) {
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
    }

    // endregion Constructors

    // region Getters and Setters

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    // endregion Getters and Setters

}
