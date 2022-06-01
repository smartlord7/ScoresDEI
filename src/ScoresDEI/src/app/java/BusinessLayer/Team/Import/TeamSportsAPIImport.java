package BusinessLayer.Team.Import;

import java.util.StringJoiner;

public class TeamSportsAPIImport {
    private String name;
    private String code;
    private String country;
    private Integer founded;

    public TeamSportsAPIImport() {
    }

    public TeamSportsAPIImport(String name, String code, String country, Integer founded) {
        this.name = name;
        this.code = code;
        this.country = country;
        this.founded = founded;
    }

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
}
