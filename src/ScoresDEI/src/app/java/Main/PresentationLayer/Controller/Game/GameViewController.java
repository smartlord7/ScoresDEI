package Main.PresentationLayer.Controller.Game;

import Main.BusinessLayer.Game.GameReader;
import Main.BusinessLayer.Game.GameWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static Main.Util.ApplicationConst.APP_NAME;

@Controller
@RequestMapping(path = APP_NAME + "/game")
public class GameViewController {

    @Autowired
    private GameReader reader;

    @Autowired
    private GameWriter writer;

    @GetMapping
    public ModelAndView getAll(Model model) {
        model.addAttribute("games", reader.getAll());

        return new ModelAndView("game/index");
    }
}
