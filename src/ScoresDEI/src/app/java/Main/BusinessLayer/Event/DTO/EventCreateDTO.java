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

import Main.BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import Main.DataLayer.Enum.EventTypeEnum;
import Main.DataLayer.Model.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class EventCreateDTO implements BaseEntityCreateDTO {

    // region Private Properties

    private Long id;
    private EventTypeEnum eventType;
    private Date occurrenceTime;
    private String description;
    private Long gameId;
    private Long playerId;
    @JsonIgnore
    private Player player;

    // endregion Private Properties

    // region Constructors

    public EventCreateDTO() {
    }

    public EventCreateDTO(EventTypeEnum eventType, Date occurrenceType, String description, Long gameId, Long playerId) {
        this.eventType = eventType;
        this.occurrenceTime = occurrenceType;
        this.description = description;
        this.gameId = gameId;
        this.playerId = playerId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // endregion Getters and Setters

}
