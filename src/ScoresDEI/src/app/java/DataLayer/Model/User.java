package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<Role> role = new ArrayList<Role>();

    public User() {
    }

    public User(String userName, String email, String phoneNumber, String passwordHash) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
    }

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

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
