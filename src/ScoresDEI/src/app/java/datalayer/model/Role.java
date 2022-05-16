package datalayer.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="roleId", updatable = false, nullable = false)
    private Long id;

    @Column(length = 1024, nullable = false)
    private String userName;

    @Column(length = 4096)
    private String Description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
