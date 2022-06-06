package Main.PresentationLayer.Controller.Game;

import Main.BusinessLayer.Event.DTO.EventCreateDTO;
import Main.BusinessLayer.Event.EventWriter;
import Main.BusinessLayer.Game.DTO.GameCreateDTO;
import Main.BusinessLayer.Game.DTO.GameUpdateDTO;
import Main.BusinessLayer.Game.GameReader;
import Main.BusinessLayer.Game.GameWriter;
import Main.BusinessLayer.Team.TeamReader;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = APP_NAME + "/game")
public class GameViewController {

    @Autowired
    private GameReader reader;

    @Autowired
    private GameWriter writer;

    @Autowired
    private EventWriter eventWriter;

    @Autowired
    private TeamReader teamReader;

    @GetMapping
    public ModelAndView index(Model model) {
        model.addAttribute("games", reader.getAll());
        model.addAttribute("game", new GameCreateDTO());
        model.addAttribute("teams", teamReader.getAll());

        return new ModelAndView("game/index");
    }

    @PostMapping
    public ModelAndView create(GameCreateDTO dto, Model model) throws ParseException {
        writer.create(dto);

        return details(dto.getId(), model);
    }

    @GetMapping("/{id}")
    public ModelAndView details(@PathVariable Long id, Model model) {
        GameUpdateDTO details = reader.getById(id);
        EventCreateDTO event = new EventCreateDTO();
        event.setGameId(details.getId());
        model.addAttribute("game", details);
        model.addAttribute("event", event);

        return new ModelAndView("game/details");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, Model model) {
        writer.deleteById(id);

        return index(model);
    }

    @PostMapping("/{id}/event")
    public ModelAndView createEvent(@PathVariable Long id, EventCreateDTO dto, Model model) throws ParseException {
        dto.setGameId(id);
        dto = eventWriter.create(dto);

        return details(id, model);
    }
    
    @GetMapping("/{id}/event/{eventId}")
    public ModelAndView toggleApproveEvent(@PathVariable Long id, @PathVariable Long eventId, Model model) {
        eventWriter.toggleApprove(eventId);

        return new ModelAndView("redirect:/scoresDEI/game/" + id);
    }
}
