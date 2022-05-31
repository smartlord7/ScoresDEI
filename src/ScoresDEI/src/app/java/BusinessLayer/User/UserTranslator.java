package BusinessLayer.User;

import BusinessLayer.User.DTO.UserCreateDTO;
import BusinessLayer.User.DTO.UserListDTO;
import DataLayer.Model.User;
import Util.PasswordHasher;

import java.util.stream.Collectors;

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
