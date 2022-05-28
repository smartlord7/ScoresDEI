package BusinessLayer.Event;

import BusinessLayer.Base.BaseEntityDTO;
import BusinessLayer.Base.BaseEntityTranslator;
import DataLayer.Model.Event;
import org.springframework.stereotype.Service;

@Service
public class EventTranslator extends BaseEntityTranslator<EventCreateDTO,
        EventUpdateDTO,
        EventListDTO,
        Event> {

    @Override
    public EventUpdateDTO toUpdateDTO(Event model) {
        return null;
    }

    @Override
    public EventCreateDTO toCreateDTO(Event model) {
        return null;
    }

    @Override
    public EventListDTO toListDTO(Event models) {
        return null;
    }

    @Override
    public Event toModel(BaseEntityDTO dto) {
        return null;
    }
}
