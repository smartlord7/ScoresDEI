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

package PresentationLayer.Controller.Team;

import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamListDTO;
import BusinessLayer.Team.DTO.TeamListDetailedDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import BusinessLayer.Team.Import.TeamImportResultDTO;
import BusinessLayer.Team.TeamReader;
import BusinessLayer.Team.TeamWriter;
import Util.ApplicationConst;
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

    // endregion Public Methods

}
