package PresentationLayer.Auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint, Serializable {

    // region Private Properties

    @Serial
    private static final long serialVersionUID = -7858869558953243875L;

    // endregion Private Properties

    // region Public Methods

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }

    // endregion Public Methods

}