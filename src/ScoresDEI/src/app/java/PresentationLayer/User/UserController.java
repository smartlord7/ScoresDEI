package PresentationLayer.User;

import BusinessLayer.User.DTO.JWTGrantDTO;
import BusinessLayer.User.DTO.UserCreateDTO;
import BusinessLayer.User.DTO.UserListDTO;
import BusinessLayer.User.DTO.UserLoginDTO;
import BusinessLayer.User.UserReader;
import BusinessLayer.User.UserWriter;
import PresentationLayer.Auth.JWTProvider;
import PresentationLayer.Auth.UserAuthDetailsProvider;
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
@RequestMapping(path = "/scoresDEI/api/user")
public class UserController {
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

    @PostMapping("/")
    public UserCreateDTO create(@RequestBody UserCreateDTO dto) {
        return writer.create(dto);
    }

    @GetMapping("/")
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

    private void authenticate(String username, String password) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
