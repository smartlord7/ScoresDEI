package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name = "User_")
@Table(name = "User_")
public class User extends AbstractAuditable<User, Long> implements Serializable, BaseEntityModel {
    @Column(length = 1024, nullable = false)
    private String userName;

    @Column(length = 1024, nullable = false, unique = true)
    private String email;

    @Column(length = 1024, nullable = false, unique = true)
    private String phoneNumber;

    @Column(length = 256, nullable = false)
    private String passwordHash;

    @ManyToMany
    private Collection<Role> role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
