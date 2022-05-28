package BusinessLayer.User;

import BusinessLayer.Base.BaseEntityReader;
import DataLayer.Model.User;
import DataLayer.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserReader extends BaseEntityReader<UserListDTO,
        UserUpdateDTO,
        User,
        UserRepository> {
}
