/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

package Main.BusinessLayer.Base;

import Main.BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import Main.BusinessLayer.Base.DTO.BaseEntityListDTO;
import Main.BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import Main.DataLayer.Base.BaseEntityModel;
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
