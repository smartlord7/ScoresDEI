package PresentationLayer.Exception;

import BusinessLayer.Exception.DTO.ExceptionListDTO;
import BusinessLayer.Exception.ExceptionReader;
import Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/exception")
public class ExceptionController {

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
