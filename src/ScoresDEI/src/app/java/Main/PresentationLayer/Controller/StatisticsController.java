package Main.PresentationLayer.Controller;

import Main.BusinessLayer.Player.PlayerReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static Main.Util.ApplicationConst.APP_NAME;

@Controller
@RequestMapping(path = APP_NAME + "/statistics")
public class StatisticsController {
    @Autowired
    private PlayerReader playerReader;

    @GetMapping
    public ModelAndView index(Model model) {
        model.addAttribute("bestScorer", playerReader.getBestScorer());

        return new ModelAndView("statistics/index");
    }
}
