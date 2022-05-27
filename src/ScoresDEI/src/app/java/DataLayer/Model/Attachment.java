package DataLayer.Model;

import DataLayer.Enum.StorageTypeEnum;
import javax.persistence.*;

public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="attachmentId", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private StorageTypeEnum storageType;

    @Column(length = 4096, nullable = false)
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
