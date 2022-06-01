package BusinessLayer.User.DTO;

import BusinessLayer.Base.DTO.BaseEntityDTO;

import java.util.StringJoiner;

public class JWTGrantDTO implements BaseEntityDTO {
    private String token;

    public JWTGrantDTO(String token) {
        this.token = token;
    }

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
}
