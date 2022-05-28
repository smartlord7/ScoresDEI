package BusinessLayer.Event;

import BusinessLayer.Base.BaseEntityWriter;
import DataLayer.Model.Event;
import DataLayer.Repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventWriter extends BaseEntityWriter<EventCreateDTO,
        EventUpdateDTO,
        Event,
        EventRepository> {
}
