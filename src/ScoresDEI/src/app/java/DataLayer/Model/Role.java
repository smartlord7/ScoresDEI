package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;

@Entity(name = "Role")
@Table(name = "Role")
public class Role extends AbstractAuditable<User, Long> implements BaseEntityModel {
    @Column(length = 1024, nullable = false)
    private String roleName;

    @Column(length = 4096)
    private String description;

    public Role() {
    }

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public Role(Long id) {
        setId(id);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String userName) {
        this.roleName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
