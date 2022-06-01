package BusinessLayer.User.DTO;

import BusinessLayer.Base.DTO.BaseEntityListDTO;

import java.util.StringJoiner;

public class UserListDTO implements BaseEntityListDTO {

    // region Private Properties

    private Long id;
    private String userName;
    private String email;
    private String role;

    // endregion Private Properties

    // region Constructors

    public UserListDTO() {
    }

    public UserListDTO(Long id, String userName, String email, String role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

    // endregion Constructors

    // region Getters and Setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserListDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .add("role='" + role + "'")
                .toString();
    }

    // endregion Getters and Setters

}
