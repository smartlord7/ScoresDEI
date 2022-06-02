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

package Main.PresentationLayer.Controller.User;

import Main.BusinessLayer.User.DTO.JWTGrantDTO;
import Main.BusinessLayer.User.DTO.UserCreateDTO;
import Main.BusinessLayer.User.DTO.UserListDTO;
import Main.BusinessLayer.User.DTO.UserLoginDTO;
import Main.BusinessLayer.User.UserReader;
import Main.BusinessLayer.User.UserWriter;
import Main.DataLayer.Enum.RoleEnum;
import Main.DataLayer.Model.Role;
import Main.DataLayer.Repository.RoleRepository;
import Main.PresentationLayer.Auth.JWTProvider;
import Main.PresentationLayer.Auth.UserAuthDetailsProvider;
import Main.Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class UserAPIController {

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

    @Autowired
    private RoleRepository roles;

    // endregion Private Properties

    // region Public Methods

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateDTO dto) {
        UserDetails session = userAuthDetailsProvider.getSession();
        Long roleId = dto.getRoleId();
        Role adminRole = roles.getFirstByRoleName("Admin");

        if (roleId != null) {
            Role role = roles.getById(roleId);
            // if a non-admin user (or not authenticated) tries to create a user with role other thant USER
            if (!role.getRoleName().equals(RoleEnum.ROLE_USER.toString()) &&
                    (session == null || !session.getAuthorities().contains(adminRole))) {
                return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
            }
        }

        return new ResponseEntity<UserCreateDTO>(writer.create(dto), HttpStatus.OK);
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
