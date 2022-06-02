package PresentationLayer.Exception;

import BusinessLayer.Exception.DTO.ExceptionCreateDTO;
import BusinessLayer.Exception.ExceptionWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class ExceptionInterceptor {
    @Autowired
    private ExceptionWriter writer;

    @Value("${app.name}")
    private String APP_NAME;

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionCreateDTO processRuntimeException(RuntimeException e) {
        return writer.create(new ExceptionCreateDTO(
                e.getMessage(),
                Arrays.toString(e.getStackTrace()),
                APP_NAME,
                e.getCause().toString()
        ));
    }
}
