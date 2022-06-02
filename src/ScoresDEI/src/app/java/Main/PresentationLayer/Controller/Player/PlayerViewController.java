package Main.PresentationLayer.Controller.Player;

import Main.BusinessLayer.Player.PlayerReader;
import Main.BusinessLayer.Player.PlayerWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static Main.Util.ApplicationConst.APP_NAME;

@Controller
@RequestMapping(path = APP_NAME + "/player")
public class PlayerViewController {
    @Autowired
    private PlayerReader reader;

    @Autowired
    private PlayerWriter writer;

    @GetMapping
    public ModelAndView index(Model model) {
        model.addAttribute("players", reader.getAll());
        model.addAttribute("bestScorer", reader.getBestScorer());

        return new ModelAndView("player/index");
    }
}
