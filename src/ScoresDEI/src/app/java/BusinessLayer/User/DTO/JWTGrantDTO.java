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
