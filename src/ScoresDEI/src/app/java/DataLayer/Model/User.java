package DataLayer.Model;

import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "User")
public class User extends AbstractAuditable<Long, User> implements Serializable {
    @Column(length = 1024, nullable = false)
    private String userName;

    @Column(length = 1024, nullable = false, unique = true)
    private String email;

    @Column(length = 1024, nullable = false, unique = true)
    private String phoneNumber;

    @Column(length = 512, nullable = false)
    private String passwordHash;

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
