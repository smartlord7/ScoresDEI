package BusinessLayer.Base;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import BusinessLayer.Base.DTO.BaseEntityDTO;
import BusinessLayer.Base.DTO.BaseEntityListDTO;
import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Base.BaseEntityModel;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseEntityTranslator<CreateDTO extends BaseEntityCreateDTO,
        UpdateDTO extends BaseEntityUpdateDTO,
        ListDTO extends BaseEntityListDTO,
        Model extends BaseEntityModel> {

    public abstract UpdateDTO toUpdateDTO(Model model);
    public abstract CreateDTO toCreateDTO(Model model);
    public abstract ListDTO toListDTO(Model models);
    public abstract Model toModel(BaseEntityDTO dto);
}
