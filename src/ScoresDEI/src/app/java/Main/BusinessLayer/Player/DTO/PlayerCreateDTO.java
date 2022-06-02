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

package Main.BusinessLayer.Player.DTO;

import Main.BusinessLayer.Base.DTO.BaseEntityCreateDTO;
import Main.DataLayer.Enum.PlayerPositionEnum;

import java.util.Date;
import java.util.StringJoiner;

public class PlayerCreateDTO implements BaseEntityCreateDTO {

    // region Private Properties

    private Long id;
    private String playerName;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private PlayerPositionEnum position;
    private Long teamId;
    private String nationality;
    private Double height;
    private Double weight;

    // endregion Private Properties

    // region Constructors

    public PlayerCreateDTO() {
    }

    public PlayerCreateDTO(String playerName, String firstName, String lastName, Date birthDate, PlayerPositionEnum position, Long teamId, String nationality, Double height, Double weight) {
        this.playerName = playerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.position = position;
        this.teamId = teamId;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
    }

    // endregion Constructors

    // region Getters and Setters

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public PlayerPositionEnum getPosition() {
        return position;
    }

    public void setPosition(PlayerPositionEnum position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerCreateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("playerName='" + playerName + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("birthDate=" + birthDate)
                .add("position=" + position)
                .add("teamId=" + teamId)
                .add("nationality='" + nationality + "'")
                .add("height=" + height)
                .add("weight=" + weight)
                .toString();
    }

    // endregion Getters and Setters

}
