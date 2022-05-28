package BusinessLayer.Role;

import BusinessLayer.Base.BaseEntityWriter;
import DataLayer.Model.Role;
import DataLayer.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleWriter extends BaseEntityWriter<RoleCreateDTO,
        RoleUpdateDTO,
        Role,
        RoleRepository> {
}
