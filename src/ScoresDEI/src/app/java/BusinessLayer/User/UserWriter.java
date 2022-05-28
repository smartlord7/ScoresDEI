package BusinessLayer.User;

import BusinessLayer.Base.BaseEntityWriter;
import DataLayer.Model.User;
import DataLayer.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserWriter extends BaseEntityWriter<UserCreateDTO,
        UserUpdateDTO,
        User,
        UserRepository> {
}
