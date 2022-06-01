package PresentationLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerListDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import BusinessLayer.Player.PlayerReader;
import BusinessLayer.Player.PlayerWriter;
import Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/player")
public class PlayerController {
    @Autowired
    private PlayerReader reader;

    @Autowired
    private PlayerWriter writer;

    @GetMapping("/")
    public List<PlayerListDTO> getAll() {
        return reader.getAll();
    }

    @GetMapping("/{id}")
    public PlayerUpdateDTO getById(@PathVariable Long id) {
        return reader.getById(id);
    }

    @GetMapping("/bestScorer")
    public PlayerUpdateDTO getBestScorer() {
        return reader.getBestScorer();
    }

    @PostMapping("/")
    public PlayerCreateDTO create(@RequestBody PlayerCreateDTO dto) {
        return writer.create(dto);
    }

    @DeleteMapping("/{id}")
    public PlayerUpdateDTO deleteById(@PathVariable Long id) {
        return writer.deleteById(id);
    }

    @PutMapping("/")
    public PlayerUpdateDTO update(@RequestBody PlayerUpdateDTO dto) {
        return writer.update(dto);
    }
}
