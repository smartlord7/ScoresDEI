package Main.PresentationLayer.Controller.Team;

import Main.BusinessLayer.Team.TeamReader;
import Main.BusinessLayer.Team.TeamWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ModelAndView index(Model model) {
        model.addAttribute("teams", reader.getAllDetailed());

        return new ModelAndView("team/index");
    }
}
