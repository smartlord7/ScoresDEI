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

import Main.BusinessLayer.Exception.DTO.ExceptionCreateDTO;
import Main.BusinessLayer.Exception.ExceptionWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class ExceptionInterceptor {

    // region Private Properties

    @Autowired
    private ExceptionWriter writer;

    @Value("${app.name}")
    private String APP_NAME;

    // endregion Private Properties

    // region Public Methods

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionCreateDTO processRuntimeException(RuntimeException e) {
        String cause = null;
        if (e.getCause() != null) {
            cause = e.getCause().toString();
        }

        return writer.create(new ExceptionCreateDTO(
                e.getMessage(),
                Arrays.toString(e.getStackTrace()),
                APP_NAME,
                cause
        ));
    }

    // endregion Public Methods

}
