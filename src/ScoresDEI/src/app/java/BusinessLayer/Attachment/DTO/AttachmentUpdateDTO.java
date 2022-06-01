package BusinessLayer.Attachment.DTO;

import BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import DataLayer.Enum.StorageTypeEnum;

import java.util.StringJoiner;

public class AttachmentUpdateDTO implements BaseEntityUpdateDTO {
    private StorageTypeEnum storageType;
    private String path;

    public AttachmentUpdateDTO() {
    }

    public AttachmentUpdateDTO(StorageTypeEnum storageType, String path) {
        this.storageType = storageType;
        this.path = path;
    }

    public StorageTypeEnum getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageTypeEnum storageType) {
        this.storageType = storageType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AttachmentUpdateDTO.class.getSimpleName() + "[", "]")
                .add("storageType=" + storageType)
                .add("path='" + path + "'")
                .toString();
    }
}
