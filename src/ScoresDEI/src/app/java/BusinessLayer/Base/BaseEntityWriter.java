package BusinessLayer.Base;

import DataLayer.Base.BaseEntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseEntityWriter<CreateDTO extends BaseEntityCreateDTO,
        UpdateDTO extends BaseEntityUpdateDTO,
        EntityModel extends BaseEntityModel,
        Repository extends JpaRepository<EntityModel, Long>> {

    @Autowired
    protected Repository repository;

    @Autowired
    protected BaseEntityTranslator<CreateDTO, UpdateDTO, BaseEntityListDTO, EntityModel> translator;

    protected CreateDTO create(CreateDTO dto) {
        repository.save(translator.toModel(dto));

        return dto;
    }

    protected UpdateDTO update(UpdateDTO dto) {
        repository.save(translator.toModel(dto));

        return dto;
    }
}
