package BusinessLayer.Event.DTO;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import DataLayer.Enum.EventTypeEnum;
import DataLayer.Model.Player;

import java.util.Date;

public class EventCreateDTO implements BaseEntityCreateDTO {
    private Long id;
    private EventTypeEnum eventType;
    private Date occurrenceTime;
    private String description;
    private Long gameId;
    private Long playerId;
    private Player player;

    public EventCreateDTO() {
    }

    public EventCreateDTO(EventTypeEnum eventType, Date occurrenceType, String description, Long gameId, Long playerId) {
        this.eventType = eventType;
        this.occurrenceTime = occurrenceType;
        this.description = description;
        this.gameId = gameId;
        this.playerId = playerId;
    }

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
}
