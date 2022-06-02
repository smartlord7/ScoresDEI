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

package Main.PresentationLayer.Controller.Exception;

import Main.BusinessLayer.Exception.DTO.ExceptionListDTO;
import Main.BusinessLayer.Exception.ExceptionReader;
import Main.Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/exception")
public class ExceptionAPIController {

    // region Private Properties

    @Autowired
    private ExceptionReader reader;

    // endregion Private Properties

    // region Public Methods

    @GetMapping
    public List<ExceptionListDTO> getAll() {
        return reader.getAll();
    }

    // endregion Public Methods
}
