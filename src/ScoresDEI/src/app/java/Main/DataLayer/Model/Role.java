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

package Main.DataLayer.Model;

import Main.DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity(name = "Role")
@Table(name = "Role")
public class Role extends AbstractAuditable<User, Long> implements BaseEntityModel, GrantedAuthority {

    // region Private Properties

    @Column(length = 1024, nullable = false)
    private String roleName;

    @Column(length = 4096)
    private String description;

    // endregion Private Properties

    // region Constructors

    public Role() {
    }

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    // endregion Constructors

    // region Public Properties

    public Role(Long id) {
        setId(id);
    }

    public String getRoleName() {
        return roleName;
    }

    // endregion Public Properties

    // region Getters and Setters

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }

    // endregion Getters and Setters

}
