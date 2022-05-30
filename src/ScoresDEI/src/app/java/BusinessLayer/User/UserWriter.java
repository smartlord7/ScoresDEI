package BusinessLayer.User;

import BusinessLayer.User.DTO.UserCreateDTO;
import DataLayer.Model.User;
import DataLayer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserWriter {
    @Autowired
    private UserRepository users;

    @Transactional
    public UserCreateDTO create(UserCreateDTO dto) {
        User u;
        u = UserTranslator.toModel(dto);

        users.save(u);

        dto.setId(u.getId());

        return dto;
    }
}
