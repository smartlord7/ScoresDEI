package Main.PresentationLayer.Controller.Team;

import Main.BusinessLayer.Player.Import.PlayerImportDataDTO;
import Main.BusinessLayer.Team.DTO.TeamImportDataDTO;
import Main.BusinessLayer.Team.TeamReader;
import Main.BusinessLayer.Team.TeamWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static Main.Util.ApplicationConst.APP_NAME;

@Controller
@RequestMapping(path = APP_NAME + "/team")
public class TeamViewController {
    @Autowired
    private TeamReader reader;

    @Autowired
    private TeamWriter writer;

    @Value("${sports_api.api_key}")
    private String SPORTS_API_KEY;

    @GetMapping
    public ModelAndView index(Model model) {
        model.addAttribute("teams", reader.getAllDetailed());
        model.addAttribute("importData", new PlayerImportDataDTO());

        return new ModelAndView("team/index");
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

        return new ModelAndView("redirect:/scoresDEI/team#");
    }
}