package BusinessLayer.User;

import BusinessLayer.User.DTO.UserListDTO;
import DataLayer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserReader {

    // region Private Properties

    @Autowired
    private UserRepository users;

    // endregion Private Properties

    // region Public Methods

    public List<UserListDTO> getAll() {
        return users.findAll()
                .stream()
                .map(UserTranslator::toListDTO)
                .collect(Collectors.toList());
    }

    // endregion Public Methods

}
