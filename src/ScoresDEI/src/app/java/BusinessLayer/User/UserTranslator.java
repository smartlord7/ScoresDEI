package BusinessLayer.User;

import BusinessLayer.Base.BaseEntityDTO;
import BusinessLayer.Base.BaseEntityTranslator;
import DataLayer.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserTranslator extends BaseEntityTranslator<UserCreateDTO,
        UserUpdateDTO,
        UserListDTO,
        User> {

    @Override
    public UserUpdateDTO toUpdateDTO(User model) {
        return null;
    }

    @Override
    public UserCreateDTO toCreateDTO(User model) {
        return null;
    }

    @Override
    public UserListDTO toListDTO(User models) {
        return null;
    }

    @Override
    public User toModel(BaseEntityDTO dto) {
        return null;
    }
}
