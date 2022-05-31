package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import DataLayer.Enum.StorageTypeEnum;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;

@Entity(name = "Attachment")
@Table(name = "Attachment")
public class Attachment extends AbstractAuditable<User, Long> implements BaseEntityModel {

    // region Private Properties

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private StorageTypeEnum storageType;

    @Column(length = 4096, nullable = false)
    private String path;

    // endregion Private Properties

    // region Getters,Setters and Constructors

    public Attachment() {
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

    // endregion Getters,Setters and Constructors

}
