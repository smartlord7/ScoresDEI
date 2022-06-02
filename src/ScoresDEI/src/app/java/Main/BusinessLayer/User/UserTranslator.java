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

package Main.BusinessLayer.User;

import Main.BusinessLayer.User.DTO.UserCreateDTO;
import Main.BusinessLayer.User.DTO.UserListDTO;
import Main.DataLayer.Model.User;
import Main.Util.PasswordHasher;
import org.springframework.stereotype.Service;

@Service
public class UserTranslator {

    // region Public Methods

    public static User toModel(UserCreateDTO dto) {
        return new User(
                dto.getUserName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                PasswordHasher.encrypt(dto.getPassword())
        );
    }

    public static UserListDTO toListDTO(User model) {
        return new UserListDTO(
                model.getId(),
                model.getUserName(),
                model.getEmail(),
                model.getRole().stream().toList().get(0).getRoleName()
        );
    }

    // endregion Public Methods

}
