package BusinessLayer.Exception;

import BusinessLayer.Exception.DTO.ExceptionCreateDTO;
import DataLayer.Model.Exception;
import DataLayer.Repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionWriter {
    @Autowired
    private ExceptionRepository exceptions;

    public ExceptionCreateDTO create(ExceptionCreateDTO dto) {
        Exception e = ExceptionTranslator.toModel(dto);
        exceptions.save(e);
        dto.setId(e.getId());

        return dto;
    }
}
