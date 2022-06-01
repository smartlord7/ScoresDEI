package BusinessLayer.User.DTO;

import BusinessLayer.Base.DTO.BaseEntityDTO;

import java.util.StringJoiner;

public class UserLoginDTO implements BaseEntityDTO {

    // region Private Properties

    private String userName;
    private String password;

    // endregion Private Properties

    // region Constructors

    public UserLoginDTO() {
    }

    public UserLoginDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // endregion Constructors

    // region Getters and Setters

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserLoginDTO.class.getSimpleName() + "[", "]")
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .toString();
    }

    // endregion Getters and Setters

}
