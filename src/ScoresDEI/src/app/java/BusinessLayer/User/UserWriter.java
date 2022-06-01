package BusinessLayer.User;

import BusinessLayer.User.DTO.UserCreateDTO;
import DataLayer.Model.User;
import DataLayer.Repository.RoleRepository;
import DataLayer.Repository.UserRepository;
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
