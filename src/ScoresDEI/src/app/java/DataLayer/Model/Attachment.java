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
