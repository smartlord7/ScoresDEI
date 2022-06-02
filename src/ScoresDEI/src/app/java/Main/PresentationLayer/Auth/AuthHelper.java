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

import Main.BusinessLayer.User.DTO.UserLoginResultDTO;
import Main.BusinessLayer.User.DTO.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class AuthHelper {

    // region Private Properties

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    private UserAuthDetailsProvider userAuthDetailsProvider;

    // endregion Private Properties

    // region Private Methods

    /**
     * Method to authenticate a user.
     * @param username is the user login.
     * @param password is the user password.
     * @throws Exception
     */
    private void authenticate_(String username, String password) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    // endregion Private Methods

    // region Public Methods

    public UserLoginResultDTO authenticate(UserLoginDTO dto) throws Exception {
        authenticate_(dto.getUserName(), dto.getPassword());
        UserDetails userDetails = userAuthDetailsProvider
                .loadUserByUsername(dto.getUserName());
        String token = jwtProvider.generateToken(userDetails);
        Date expirationDate = jwtProvider.getExpirationDateFromToken(token);

        return new UserLoginResultDTO(
                token,
                expirationDate,
                dto.getUserName()
        );
    }

    // endregion Public Methods

}
