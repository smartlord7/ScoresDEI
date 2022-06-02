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

package Main.BusinessLayer.User.DTO;

import Main.BusinessLayer.Base.DTO.BaseEntityDTO;

import java.util.Date;
import java.util.StringJoiner;

public class UserLoginResultDTO implements BaseEntityDTO {

    // region Private Properties

    private String token;
    private String userName;
    private Date expirationDate;

    // endregion Private Properties

    // region Constructors

    public UserLoginResultDTO() {
    }

    public UserLoginResultDTO(String token, Date expirationDate, String userName) {
        this.token = token;
        this.expirationDate = expirationDate;
        this.userName = userName;
    }

    // endregion Constructors

    // region Getters and Setters

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserLoginResultDTO.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .add("userName='" + userName + "'")
                .add("expirationDate=" + expirationDate)
                .toString();
    }

    // endregion Getters and Setters

}
