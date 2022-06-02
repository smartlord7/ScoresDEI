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

package PresentationLayer.Game;

import BusinessLayer.Event.DTO.EventListDTO;
import BusinessLayer.Game.DTO.GameCreateDTO;
import BusinessLayer.Game.DTO.GameListDTO;
import BusinessLayer.Game.DTO.GameUpdateDTO;
import BusinessLayer.Game.GameReader;
import BusinessLayer.Game.GameWriter;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/game")
public class GameController {

    // region Private Properties

    @Autowired
    private GameReader reader;

    @Autowired
    private GameWriter writer;

    // endregion Private Properties

    // region Public Methods

    @GetMapping
    public List<GameListDTO> getAll() {
        return reader.getAll();
    }

    @GetMapping("/{id}/events")
    public List<EventListDTO> getEvents(@PathVariable Long id) {
        return reader.getEvents(id);
    }

    @GetMapping("/{id}")
    public GameUpdateDTO getById(@PathVariable Long id) {
        return reader.getById(id);
    }

    @PostMapping
    public GameCreateDTO create(@RequestBody GameCreateDTO dto) {
        return writer.create(dto);
    }

    @DeleteMapping("/{id}")
    public GameUpdateDTO deleteById(@PathVariable Long id) {
        return writer.deleteById(id);
    }

    @PutMapping
    public GameUpdateDTO update(@RequestBody GameUpdateDTO dto) {
        return writer.update(dto);
    }

    // endregion Public Methods

}
