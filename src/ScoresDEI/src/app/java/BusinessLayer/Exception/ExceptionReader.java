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
