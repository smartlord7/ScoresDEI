package BusinessLayer.Base;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import BusinessLayer.Base.DTO.BaseEntityListDTO;
import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Base.BaseEntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseEntityWriter<CreateDTO extends BaseEntityCreateDTO,
        UpdateDTO extends BaseEntityUpdateDTO,
        EntityModel extends BaseEntityModel,
        Repository extends JpaRepository<EntityModel, Long>> {

    // region Protected Properties

    @Autowired
    protected Repository repository;

    @Autowired
    protected BaseEntityTranslator<CreateDTO, UpdateDTO, BaseEntityListDTO, EntityModel> translator;

    // endregion Protected Properties

    // region Protected Methods

    protected CreateDTO create(CreateDTO dto) {
        repository.save(translator.toModel(dto));

        return dto;
    }

    protected UpdateDTO update(UpdateDTO dto) {
        repository.save(translator.toModel(dto));

        return dto;
    }

    // endregion Protected Methods


}
