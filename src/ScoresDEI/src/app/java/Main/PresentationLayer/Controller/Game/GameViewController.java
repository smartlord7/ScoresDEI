package Main.PresentationLayer.Controller.Game;

import Main.BusinessLayer.Game.DTO.GameUpdateDTO;
import Main.BusinessLayer.Game.GameReader;
import Main.BusinessLayer.Game.GameWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ModelAndView index(Model model) {
        model.addAttribute("games", reader.getAll());

        return new ModelAndView("game/index");
    }

    @GetMapping("/{id}")
    public ModelAndView details(@PathVariable Long id, Model model) {
        GameUpdateDTO details = reader.getById(id);
        model.addAttribute("gameDetails", details);

        return new ModelAndView("game/details");
    }
}
