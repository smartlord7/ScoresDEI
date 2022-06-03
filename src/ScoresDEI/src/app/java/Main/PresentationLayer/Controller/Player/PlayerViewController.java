package Main.PresentationLayer.Controller.Player;

import Main.BusinessLayer.Player.DTO.PlayerCreateDTO;
import Main.BusinessLayer.Player.DTO.PlayerUpdateDTO;
import Main.BusinessLayer.Player.Import.PlayerImportDataDTO;
import Main.BusinessLayer.Player.PlayerReader;
import Main.BusinessLayer.Player.PlayerWriter;
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
import static Main.Util.ApplicationConst.REDIRECT;

@Controller
@RequestMapping(path = APP_NAME + "/player")
public class PlayerViewController {
    @Autowired
    private PlayerReader reader;

    @Autowired
    private PlayerWriter writer;

    @Value("${sports_api.api_key}")
    private String SPORTS_API_KEY;

    @GetMapping
    public ModelAndView index(Model model) {
        model.addAttribute("players", reader.getAll());
        model.addAttribute("player", new PlayerCreateDTO());
        model.addAttribute("bestScorer", reader.getBestScorer());
        model.addAttribute("importData", new PlayerImportDataDTO());

        return new ModelAndView("player/index");
    }

    @PostMapping
    public ModelAndView create(PlayerCreateDTO dto, Model model) throws ParseException {
        writer.create(dto);

        return index(model);
    }
    @GetMapping("/{id}")
    public ModelAndView details(@PathVariable Long id, Model model) throws ParseException {
        PlayerUpdateDTO details = reader.getById(id);
        model.addAttribute("player", details);

        return new ModelAndView("player/details");
    }


    @PostMapping(path = "/import")
    public ModelAndView importViaSportsAPI(PlayerImportDataDTO importData, Model model) {
        if (importData != null) {
             model.addAttribute("importResult",
                     writer.importViaSportsAPI(SPORTS_API_KEY,
                    importData.getLeague(),
                    importData.getSeason(),
                    importData.getPage()
                     ));
        }

        return index(model);
    }
}
