package PresentationLayer.User;

import BusinessLayer.User.DTO.JWTGrantDTO;
import BusinessLayer.User.DTO.UserCreateDTO;
import BusinessLayer.User.DTO.UserListDTO;
import BusinessLayer.User.DTO.UserLoginDTO;
import BusinessLayer.User.UserReader;
import BusinessLayer.User.UserWriter;
import PresentationLayer.Auth.JWTProvider;
import PresentationLayer.Auth.UserAuthDetailsProvider;
import Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/user")
public class UserController {

    // region Private Properties

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    private UserAuthDetailsProvider userAuthDetailsProvider;

    @Autowired
    private UserReader reader;

    @Autowired
    private UserWriter writer;

    // endregion Private Properties

    // region Public Methods

    @PostMapping
    public UserCreateDTO create(@RequestBody UserCreateDTO dto) {
        return writer.create(dto);
    }

    @GetMapping
    public List<UserListDTO> getAll() {
        return reader.getAll();
    }

    @PutMapping("/login")
    public JWTGrantDTO login(@RequestBody UserLoginDTO dto) throws Exception {

        authenticate(dto.getUserName(), dto.getPassword());
        UserDetails userDetails = userAuthDetailsProvider
                .loadUserByUsername(dto.getUserName());
        String token = jwtProvider.generateToken(userDetails);

        return new JWTGrantDTO(token);
    }

    /**
     * Method to authenticate a user.
     * @param username is the user login.
     * @param password is the user password.
     * @throws Exception
     */
    private void authenticate(String username, String password) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    // endregion Public Methods

}
