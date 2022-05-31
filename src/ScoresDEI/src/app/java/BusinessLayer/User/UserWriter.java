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
    @Autowired
    private UserRepository users;

    @Autowired
    private RoleRepository roles;

    @Transactional
    public UserCreateDTO create(UserCreateDTO dto) {
        User u;
        u = UserTranslator.toModel(dto);
        u.getRole().add(roles.getById(dto.getRoleId()));

        users.save(u);

        dto.setId(u.getId());

        return dto;
    }
}
