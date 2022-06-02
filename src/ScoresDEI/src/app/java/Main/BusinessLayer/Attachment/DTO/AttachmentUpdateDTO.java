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

package Main.BusinessLayer.Attachment.DTO;

import Main.BusinessLayer.Base.DTO.BaseEntityUpdateDTO;
import Main.DataLayer.Enum.StorageTypeEnum;

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
