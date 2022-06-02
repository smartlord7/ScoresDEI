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

import Main.BusinessLayer.Base.DTO.BaseEntityCreateDTO;

import java.util.StringJoiner;

public class UserCreateDTO implements BaseEntityCreateDTO {

    // region Private Properties

    private Long id;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private Long roleId;

    // endregion Private Properties

    // region Constructors

    public UserCreateDTO() {
    }

    public UserCreateDTO(String userName, String email, String phoneNumber, String passwordHash) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = passwordHash;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserCreateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("password='" + password + "'")
                .add("roleId=" + roleId)
                .toString();
    }

    // endregion Getters and Setters

}
