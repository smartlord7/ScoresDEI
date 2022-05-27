package DataLayer.Model;

import javax.persistence.*;

@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userId", updatable = false, nullable = false)
    private Long id;

    @Column(length = 1024, nullable = false)
    private String userName;

    @Column(length = 1024, nullable = false, unique = true)
    private String email;

    @Column(length = 1024, nullable = false, unique = true)
    private String phoneNumber;

    @Column(length = 512, nullable = false)
    private String passwordHash;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
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
}
