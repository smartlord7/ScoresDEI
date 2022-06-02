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

package Main.PresentationLayer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static Main.Util.ApplicationConst.APP_NAME;
import static Main.Util.ApplicationConst.REDIRECT;

@Controller
@RequestMapping(path = APP_NAME + "/home")
public class HomeController {
    @GetMapping
    public String index() {
        return REDIRECT + "scoresDEI/game";
    }
}
