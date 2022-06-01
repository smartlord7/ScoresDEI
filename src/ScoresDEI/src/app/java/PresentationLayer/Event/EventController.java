package PresentationLayer.Event;

import BusinessLayer.Event.DTO.EventCreateDTO;
import BusinessLayer.Event.EventReader;
import BusinessLayer.Event.EventWriter;
import BusinessLayer.Game.DTO.GameCreateDTO;
import Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/event")
public class EventController {

    // region Private Properties

    @Autowired
    private EventReader reader;

    @Autowired
    private EventWriter writer;

    // endregion Private Properties

    // region Public Methods

    @PostMapping
    public EventCreateDTO create(@RequestBody EventCreateDTO dto) {
        return writer.create(dto);
    }

    // endregion Public Methods

}
