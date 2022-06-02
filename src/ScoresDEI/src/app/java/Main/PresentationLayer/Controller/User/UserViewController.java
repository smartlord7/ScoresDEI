package Main.PresentationLayer.Controller.User;

import Main.BusinessLayer.User.DTO.UserCreateDTO;
import Main.BusinessLayer.User.UserReader;
import Main.BusinessLayer.User.UserWriter;
import Main.Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@CrossOrigin
@RequestMapping(path = ApplicationConst.APP_NAME + "/user")
public class UserViewController {
    @Autowired
    private UserWriter writer;

    @Autowired
    private UserReader reader;

    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal!=null && ((Authentication) principal).isAuthenticated()) {
            return ApplicationConst.REDIRECT + "general/home";
        } else {
            return "user/login";
        }
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("dto", new UserCreateDTO());
        return "user/create";
    }

    @PostMapping("/create")
    public String create(UserCreateDTO dto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("registrationForm", dto);

            return "user/create";
        }
        try {
            writer.create(dto);
        } catch (Exception e){
            model.addAttribute("registrationForm", dto);

            return "user/create";
        }

        return ApplicationConst.REDIRECT + "/";
    }
}
