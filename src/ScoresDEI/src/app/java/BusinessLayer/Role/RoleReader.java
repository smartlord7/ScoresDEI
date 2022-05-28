package BusinessLayer.Role;

import BusinessLayer.Base.BaseEntityReader;
import DataLayer.Model.Role;
import DataLayer.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleReader extends BaseEntityReader<RoleListDTO,
        RoleUpdateDTO,
        Role,
        RoleRepository> {
}
