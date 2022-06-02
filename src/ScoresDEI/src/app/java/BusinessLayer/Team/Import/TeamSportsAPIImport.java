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

package BusinessLayer.Team.Import;

import java.util.StringJoiner;

public class TeamSportsAPIImport {

    // region Private Properties

    private String name;
    private String code;
    private String country;
    private Integer founded;

    // endregion Private Properties

    // region Constructors

    public TeamSportsAPIImport() {
    }

    public TeamSportsAPIImport(String name, String code, String country, Integer founded) {
        this.name = name;
        this.code = code;
        this.country = country;
        this.founded = founded;
    }

    // endregion Constructors

    // region Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TeamSportsAPIImport.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("code='" + code + "'")
                .add("country='" + country + "'")
                .add("founder=" + founded)
                .toString();
    }

    // endregion Getters and Setters

}
