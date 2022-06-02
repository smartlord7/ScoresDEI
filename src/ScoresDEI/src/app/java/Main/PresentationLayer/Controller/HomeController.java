package Main.PresentationLayer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "general/home" : "general/home_no_auth";
    }
}
