package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;

@Entity(name = "Role")
@Table(name = "Role")
public class Role extends AbstractAuditable<User, Long> implements BaseEntityModel {
    @Column(length = 1024, nullable = false)
    private String userName;

    @Column(length = 4096)
    private String description;

    public Role(Long id) {
        setId(id);
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
