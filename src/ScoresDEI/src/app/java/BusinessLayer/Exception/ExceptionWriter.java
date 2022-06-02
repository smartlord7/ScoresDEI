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

package BusinessLayer.Exception;

import BusinessLayer.Exception.DTO.ExceptionCreateDTO;
import DataLayer.Model.Exception;
import DataLayer.Repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExceptionWriter {
    @Autowired
    private ExceptionRepository exceptions;

    @Transactional
    public ExceptionCreateDTO create(ExceptionCreateDTO dto) {
        Exception e = ExceptionTranslator.toModel(dto);
        exceptions.save(e);
        dto.setId(e.getId());

        return dto;
    }
}
