package BusinessLayer.Role;

import BusinessLayer.Base.BaseEntityDTO;
import BusinessLayer.Base.BaseEntityTranslator;
import DataLayer.Model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleTranslator extends BaseEntityTranslator<RoleCreateDTO,
        RoleUpdateDTO,
        RoleListDTO,
        Role> {

    @Override
    public RoleUpdateDTO toUpdateDTO(Role model) {
        return null;
    }

    @Override
    public RoleCreateDTO toCreateDTO(Role model) {
        return null;
    }

    @Override
    public RoleListDTO toListDTO(Role models) {
        return null;
    }

    @Override
    public Role toModel(BaseEntityDTO dto) {
        return null;
    }
}
