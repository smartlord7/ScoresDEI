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

package Main.PresentationLayer.Controller.Event;

import Main.BusinessLayer.Event.DTO.EventCreateDTO;
import Main.BusinessLayer.Event.DTO.EventListDTO;
import Main.BusinessLayer.Event.DTO.EventUpdateDTO;
import Main.BusinessLayer.Event.EventReader;
import Main.BusinessLayer.Event.EventWriter;
import Main.Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/event")
public class EventAPIController {

    // region Private Properties

    @Autowired
    private EventReader reader;

    @Autowired
    private EventWriter writer;

    // endregion Private Properties

    // region Public Methods

    @PostMapping
    public EventCreateDTO create(@RequestBody EventCreateDTO dto) throws ParseException {
        return writer.create(dto);
    }

    @PutMapping("/{id}")
    public EventListDTO toggleApprove(@PathVariable Long id) {
        return writer.toggleApprove(id);
    }

    // endregion Public Methods

}
