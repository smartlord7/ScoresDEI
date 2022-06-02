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
import Main.DataLayer.Model.User;
import Main.DataLayer.Repository.RoleRepository;
import Main.DataLayer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserWriter {

    // region Private Properties

    @Autowired
    private UserRepository users;

    @Autowired
    private RoleRepository roles;

    // endregion Private Properties

    // region Public Methods

    @Transactional
    public UserCreateDTO create(UserCreateDTO dto) {
        User u;
        u = UserTranslator.toModel(dto);

        if (dto.getRoleId() != null) {
            u.getRole().add(roles.getById(dto.getRoleId()));
        }

        users.save(u);
        dto.setId(u.getId());

        return dto;
    }

    // endregion Public Methods

}
