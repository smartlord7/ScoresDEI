package PresentationLayer.Game;

import BusinessLayer.Event.DTO.EventListDTO;
import BusinessLayer.Game.DTO.GameCreateDTO;
import BusinessLayer.Game.DTO.GameListDTO;
import BusinessLayer.Game.DTO.GameUpdateDTO;
import BusinessLayer.Game.GameReader;
import BusinessLayer.Game.GameWriter;
import Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/game")
public class GameController {
    @Autowired
    private GameReader reader;

    @Autowired
    private GameWriter writer;

    @GetMapping("/")
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

    @PostMapping("/")
    public GameCreateDTO create(@RequestBody GameCreateDTO dto) {
        return writer.create(dto);
    }

    @PutMapping("/")
    public GameUpdateDTO update(@RequestBody GameUpdateDTO dto) {
        return writer.update(dto);
    }
}
