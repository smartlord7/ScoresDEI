package BusinessLayer.Attachment;

import BusinessLayer.Base.*;
import DataLayer.Model.Attachment;
import org.springframework.stereotype.Service;

@Service
public class AttachmentTranslator extends BaseEntityTranslator<AttachmentCreateDTO,
        AttachmentUpdateDTO,
        AttachmentListDTO,
        Attachment> {

    @Override
    public AttachmentUpdateDTO toUpdateDTO(Attachment model) {
        return null;
    }

    @Override
    public AttachmentCreateDTO toCreateDTO(Attachment model) {
        return null;
    }

    @Override
    public AttachmentListDTO toListDTO(Attachment models) {
        return null;
    }

    @Override
    public Attachment toModel(BaseEntityDTO dto) {
        return null;
    }
}
