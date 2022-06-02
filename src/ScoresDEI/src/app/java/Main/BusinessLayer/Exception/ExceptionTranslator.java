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

package Main.BusinessLayer.Exception;

import Main.BusinessLayer.Exception.DTO.ExceptionCreateDTO;
import Main.BusinessLayer.Exception.DTO.ExceptionListDTO;
import Main.DataLayer.Model.Exception;

import java.time.LocalDateTime;

public class ExceptionTranslator {

    // region Public Methods

    public static ExceptionListDTO toListDTO(Exception model) {
        LocalDateTime createDate = null;
        Long userId = null;

        if (model.getCreatedDate().isPresent()) {
            createDate = model.getCreatedDate().get();
        }

        if (model.getCreatedBy().isPresent()) {
            userId = model.getCreatedBy().get().getId();
        }

        return new ExceptionListDTO(
                model.getMessage(),
                model.getSource(),
                model.getContext(),
                userId,
                createDate
        );
    }

    public static Exception toModel(ExceptionCreateDTO dto) {
        return new Exception(
                dto.getMessage(),
                dto.getStackTrace(),
                dto.getSource(),
                dto.getContext()
        );
    }

    // endregion Public Methods

}
