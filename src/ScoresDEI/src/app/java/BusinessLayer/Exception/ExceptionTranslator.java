package BusinessLayer.Exception;

import BusinessLayer.Exception.DTO.ExceptionCreateDTO;
import BusinessLayer.Exception.DTO.ExceptionListDTO;
import DataLayer.Model.Exception;
import java.time.LocalDateTime;

public class ExceptionTranslator {
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
}
