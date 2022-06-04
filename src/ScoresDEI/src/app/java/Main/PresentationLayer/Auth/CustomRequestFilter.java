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

package Main.PresentationLayer.Auth;

import Main.BusinessLayer.User.DTO.UserLoginDTO;
import Main.BusinessLayer.User.DTO.UserLoginResultDTO;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomRequestFilter extends OncePerRequestFilter {

    // region Private Properties

    @Autowired
    private UserAuthDetailsProvider jwtUserDetailsProvider;

    @Autowired
    private JWTProvider jwtProvider;

    private final String TOKEN_PREFIX = "Bearer ";

    // endregion Private Properties

    // region Protected Methods

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain chain)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        UserLoginResultDTO userInfo = (UserLoginResultDTO) session.getAttribute("userInfo");
        String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (userInfo != null) {
            username = userInfo.getUserName();
            token = userInfo.getToken();
        }

        if (requestTokenHeader != null && requestTokenHeader.startsWith(TOKEN_PREFIX)) {
            token = requestTokenHeader.substring(TOKEN_PREFIX.length());
            try {
                username = jwtProvider.getUserNameFromToken(token);
            } catch (IllegalArgumentException e) {
                logger.error("Unable to get JWT token");
            } catch (ExpiredJwtException e) {
                logger.info("JWT token has expired");
            }
        } else {
            logger.warn("No JWT token token found");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.jwtUserDetailsProvider.loadUserByUsername(username);

            if (jwtProvider.isValidToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        chain.doFilter(request, response);
    }

    // endregion Protected Methods

}