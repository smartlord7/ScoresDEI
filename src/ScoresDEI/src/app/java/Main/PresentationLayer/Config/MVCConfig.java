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

package Main.PresentationLayer.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static Main.Util.ApplicationConst.APP_NAME;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    // region Public Methods

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( APP_NAME + "/user/create").setViewName("user/create");
        registry.addViewController( APP_NAME + "/").setViewName("general/home");
        registry.addViewController( APP_NAME + "/home").setViewName("general/home");
    }

    // endregion Public Methods

}