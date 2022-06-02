/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

package Main.PresentationLayer.Controller.User;

import Main.BusinessLayer.User.DTO.UserCreateDTO;
import Main.BusinessLayer.User.DTO.UserLoginDTO;
import Main.BusinessLayer.User.DTO.UserLoginResultDTO;
import Main.BusinessLayer.User.UserReader;
import Main.BusinessLayer.User.UserWriter;
import Main.PresentationLayer.Auth.AuthHelper;
import Main.Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping(path = ApplicationConst.APP_NAME + "/user")
public class UserViewController {

    // region Private Properties

    @Autowired
    private UserWriter writer;

    @Autowired
    private UserReader reader;

    @Autowired
    private AuthHelper authHelper;

    // endregion Private Properties

    // region Public Methods

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null && ((Authentication) principal).isAuthenticated()) {
            return ApplicationConst.REDIRECT + "general/home";
        } else {
            model.addAttribute("userLoginDTO", new UserLoginDTO());

            return "user/login";
        }
    }

    @PostMapping("/login")
    public String login(UserLoginDTO loginDTO, HttpSession session, Model model) throws Exception {
        UserLoginResultDTO loginResultDTO;
        try {
            loginResultDTO = authHelper.authenticate(loginDTO);
        } catch (Exception e) {
            model.addAttribute("error", "Wrong username or password");

            return "user/login";
        }
        session.setAttribute("user", loginResultDTO);

        return "general/home";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("userCreateDTO", new UserCreateDTO());

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

    // endregion Public Methods

}
