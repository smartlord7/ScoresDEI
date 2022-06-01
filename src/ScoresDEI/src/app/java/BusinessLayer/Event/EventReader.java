package BusinessLayer.Event;

import DataLayer.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventReader {

    // region Private Properties

    @Autowired
    private EventRepository events;

    // endregion Private Properties


}
