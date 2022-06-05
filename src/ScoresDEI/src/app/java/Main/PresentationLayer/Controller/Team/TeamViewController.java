package Main.PresentationLayer.Controller.Team;

import Main.BusinessLayer.Player.DTO.PlayerListDTO;
import Main.BusinessLayer.Player.PlayerReader;
import Main.BusinessLayer.Team.DTO.TeamCreateDTO;
import Main.BusinessLayer.Team.DTO.TeamImportDataDTO;
import Main.BusinessLayer.Team.DTO.TeamUpdateDTO;
import Main.BusinessLayer.Team.TeamReader;
import Main.BusinessLayer.Team.TeamWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

import static Main.Util.ApplicationConst.APP_NAME;

@Controller
@RequestMapping(path = APP_NAME + "/team")
public class TeamViewController {
    @Autowired
    private TeamReader reader;

    @Autowired
    private TeamWriter writer;

    @Autowired
    private PlayerReader playerReader;

    @Value("${sports_api.api_key}")
    private String SPORTS_API_KEY;

    @GetMapping
    public ModelAndView index(Model model) {
        model.addAttribute("teams", reader.getAllDetailed());
        model.addAttribute("importData", new TeamImportDataDTO());
        model.addAttribute("team", new TeamCreateDTO());

        return new ModelAndView("team/index");
    }

    @PostMapping
    public ModelAndView create(TeamCreateDTO dto, Model model) throws ParseException {
        writer.create(dto);

        return index(model);
    }

    @GetMapping("/{id}")
    public ModelAndView details(@PathVariable Long id, Model model) {
        TeamUpdateDTO details = reader.getById(id);
        model.addAttribute("team", details);
        model.addAttribute("players", playerReader.getAll());
        model.addAttribute("player", new PlayerListDTO());

        return new ModelAndView("team/details");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, Model model) {
        writer.deleteById(id);

        return index(model);
    }

    @PostMapping(path = "/import")
    public ModelAndView importViaSportsAPI(TeamImportDataDTO importData, Model model) {
        if (importData != null) {
            model.addAttribute("importResult",
                    writer.importViaSportsAPI(SPORTS_API_KEY,
                            importData.getLeague(),
                            importData.getSeason()
                    ));
        }

        return index(model);
    }

    @PostMapping(path = "/{id}/player")
    public ModelAndView removePlayer(@PathVariable Long id, PlayerListDTO player, Model model) {
        writer.addPlayer(id, player.getId());

        return details(id, model);
    }

    @GetMapping(path = "/{id}/player/{playerId}")
    public ModelAndView removePlayer(@PathVariable Long id, @PathVariable Long playerId, Model model) {
        writer.removePlayer(id, playerId);

        return details(id, model);
    }
}
