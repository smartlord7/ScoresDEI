package BusinessLayer.Attachment;

import BusinessLayer.Base.BaseEntityReader;
import DataLayer.Model.Attachment;
import DataLayer.Repository.AttachmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AttachmentReader extends BaseEntityReader<AttachmentListDTO,
        AttachmentUpdateDTO,
        Attachment,
        AttachmentRepository> {
}
