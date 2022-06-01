package BusinessLayer.Base;

import BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import BusinessLayer.Base.DTO.BaseEntityListDTO;
import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Base.BaseEntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class BaseEntityReader<ListDTO extends BaseEntityListDTO,
        UpdateDTO extends BaseEntityUpdateDTO,
        EntityModel extends BaseEntityModel,
        Repository extends JpaRepository<EntityModel, Long>> {

    // region Protected Properties

    @Autowired
    protected Repository repository;

    @Autowired
    protected BaseEntityTranslator<BaseEntityCreateDTO, UpdateDTO, ListDTO, EntityModel> translator;

    // endregion Protected Properties

    // region Protected Methods

    protected UpdateDTO getById(Long id) {
        return translator.toUpdateDTO(repository.getById(id));
    }

    protected List<ListDTO> getAll(Long id) {
        return repository.findAll()
                .stream()
                .map(entityModel -> translator
                        .toListDTO(entityModel))
                .toList();
    }

    // endregion Protected Methods


}
