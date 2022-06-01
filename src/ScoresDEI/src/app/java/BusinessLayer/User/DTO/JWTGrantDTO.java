package BusinessLayer.User.DTO;

import BusinessLayer.Base.DTO.BaseEntityDTO;

import java.util.StringJoiner;

public class JWTGrantDTO implements BaseEntityDTO {

    // region Private Properties

    private String token;

    // endregion Private Properties

    // region Constructors

    public JWTGrantDTO(String token) {
        this.token = token;
    }

    // endregion Constructors

    // region Getters and Setters

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JWTGrantDTO.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .toString();
    }

    // endregion Getters and Setters

}
