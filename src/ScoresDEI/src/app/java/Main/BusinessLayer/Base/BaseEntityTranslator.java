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
import Main.BusinessLayer.Base.DTO.BaseEntityDTO;
import Main.BusinessLayer.Base.DTO.BaseEntityListDTO;
import Main.BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import Main.DataLayer.Base.BaseEntityModel;
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
