package BusinessLayer.User;

import BusinessLayer.User.DTO.UserCreateDTO;
import DataLayer.Model.User;
import Util.PasswordHasher;

public class UserTranslator {
    public static User toModel(UserCreateDTO dto) {
        return new User(dto.getUserName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                PasswordHasher.encrypt(dto.getPassword()),
                dto.getRoleId());
    }
}
