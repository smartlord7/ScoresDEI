package BusinessLayer.Event;

import BusinessLayer.Base.BaseEntityReader;
import DataLayer.Model.Event;
import DataLayer.Repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventReader extends BaseEntityReader<EventListDTO,
        EventUpdateDTO,
        Event,
        EventRepository> {
}
