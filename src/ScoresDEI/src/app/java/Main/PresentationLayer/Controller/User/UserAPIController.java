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

import Main.BusinessLayer.User.DTO.UserLoginResultDTO;
import Main.BusinessLayer.User.DTO.UserCreateDTO;
import Main.BusinessLayer.User.DTO.UserListDTO;
import Main.BusinessLayer.User.DTO.UserLoginDTO;
import Main.BusinessLayer.User.UserReader;
import Main.BusinessLayer.User.UserWriter;
import Main.DataLayer.Enum.RoleEnum;
import Main.DataLayer.Model.Role;
import Main.DataLayer.Repository.RoleRepository;
import Main.PresentationLayer.Auth.AuthHelper;
import Main.PresentationLayer.Auth.UserAuthDetailsProvider;
import Main.Util.ApplicationConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = ApplicationConst.API_PREFIX + "/user")
public class UserAPIController {

    // region Private Properties

    @Autowired
    private UserReader reader;

    @Autowired
    private UserWriter writer;

    @Autowired
    private RoleRepository roles;

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private UserAuthDetailsProvider userAuthDetailsProvider;

    // endregion Private Properties

    // region Public Methods

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateDTO dto) {
        UserDetails session = (UserDetails) userAuthDetailsProvider.getSession();
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
    public UserLoginResultDTO login(@RequestBody UserLoginDTO dto) throws Exception {
        return authHelper.authenticate(dto);
    }

    // endregion Public Methods

}
