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

import BusinessLayer.Exception.DTO.ExceptionListDTO;
import BusinessLayer.Game.DTO.GameListDTO;
import BusinessLayer.Game.GameTranslator;
import DataLayer.Repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionReader {
    @Autowired
    private ExceptionRepository exceptions;

    public List<ExceptionListDTO> getAll() {
        return exceptions.findAll()
                .stream()
                .map(ExceptionTranslator::toListDTO)
                .toList();
    }
}
