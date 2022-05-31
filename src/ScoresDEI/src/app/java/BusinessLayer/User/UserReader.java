package BusinessLayer.User;

import BusinessLayer.Player.DTO.PlayerListDTO;
import BusinessLayer.Player.PlayerTranslator;
import BusinessLayer.User.DTO.UserListDTO;
import DataLayer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserReader {
    @Autowired
    private UserRepository users;

    public List<UserListDTO> getAll() {
        return users.findAll()
                .stream()
                .map(UserTranslator::toListDTO)
                .collect(Collectors.toList());
    }
}
