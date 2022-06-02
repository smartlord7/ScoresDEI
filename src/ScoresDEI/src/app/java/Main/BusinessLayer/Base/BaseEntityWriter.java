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
