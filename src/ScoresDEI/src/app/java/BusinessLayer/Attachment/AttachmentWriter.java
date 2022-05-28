package BusinessLayer.Attachment;

import BusinessLayer.Base.BaseEntityWriter;
import DataLayer.Model.Attachment;
import DataLayer.Repository.AttachmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AttachmentWriter extends BaseEntityWriter<AttachmentCreateDTO,
        AttachmentUpdateDTO,
        Attachment,
        AttachmentRepository> {
}
