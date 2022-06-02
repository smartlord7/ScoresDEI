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
import Main.DataLayer.Model.Exception;
import Main.DataLayer.Repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExceptionWriter {

    // region Private Properties

    @Autowired
    private ExceptionRepository exceptions;

    // endregion Private Properties

    // region Public Methods

    @Transactional
    public ExceptionCreateDTO create(ExceptionCreateDTO dto) {
        Exception e = ExceptionTranslator.toModel(dto);
        exceptions.save(e);
        dto.setId(e.getId());

        return dto;
    }

    // endregion Public Methods

}
