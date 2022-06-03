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

package Main.PresentationLayer.Controller.Team;

import Main.BusinessLayer.Team.DTO.TeamCreateDTO;
import Main.BusinessLayer.Team.DTO.TeamListDTO;
import Main.BusinessLayer.Team.DTO.TeamListDetailedDTO;
import Main.BusinessLayer.Team.DTO.TeamUpdateDTO;
import Main.BusinessLayer.Team.Import.TeamImportResultDTO;
import Main.BusinessLayer.Team.TeamReader;
import Main.BusinessLayer.Team.TeamWriter;
import Main.Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/team")
public class TeamAPIController {

    // region Private Properties

    @Autowired
    private TeamReader reader;

    @Autowired
    private TeamWriter writer;

    // endregion Private Properties

    // region Public Methods

    @GetMapping
    public List<TeamListDTO> getAll() {
        return reader.getAll();
    }

    @GetMapping("/detailed")
    public List<TeamListDetailedDTO> getAllDetailed() {
        return reader.getAllDetailed();
    }

    @GetMapping("/{id}")
    public TeamUpdateDTO getById(@PathVariable Long id) {
        return reader.getById(id);
    }

    @PostMapping
    public TeamCreateDTO create(@RequestBody TeamCreateDTO dto) {
        return writer.create(dto);
    }

    @DeleteMapping("/{id}")
    public TeamUpdateDTO deleteById(@PathVariable Long id) {
        return writer.deleteById(id);
    }

    @PutMapping
    public TeamUpdateDTO update(@RequestBody TeamUpdateDTO dto) {
        return writer.update(dto);
    }

    @GetMapping("/import")
    public TeamImportResultDTO importViaSportsAPI(@RequestHeader(value="x-apisports-key") String keyAPI,
                                                  @RequestParam long league,
                                                  @RequestParam long season) {
        return writer.importViaSportsAPI(keyAPI, league, season);
    }

    @PutMapping("/{id}/player/{playerId}")
    public TeamUpdateDTO addPlayer(@PathVariable Long id, @PathVariable Long playerId) {
        return writer.addPlayer(id, playerId);
    }

    @DeleteMapping("/{id}/player/{playerId}")
    public TeamUpdateDTO deletePlayer(@PathVariable Long id, @PathVariable Long playerId) {
        return writer.removePlayer(id, playerId);
    }

    // endregion Public Methods

}
