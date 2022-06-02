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

package BusinessLayer.Player.Import;

import BusinessLayer.Base.DTO.BaseEntityDTO;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class PlayerSportsAPIImport implements BaseEntityDTO {

    // region Private Properties

    private Player player;
    private List<Object> statistics;

    // endregion Private Properties

    // region Inner Classes

    public static class Player {

        // region Private Properties


        private String name;
        private String firstname;
        private String lastname;
        private Birth birth;
        private String nationality;
        private String height;
        private String weight;

        // endregion Private Properties

        public static class Birth {

            // region Private Properties


            private Date date;

            // endregion Private Properties


            // region Constructors

            public Birth() {
            }

            // endregion Constructors

            // region Getters and Setters

            public Birth(Date date) {
                this.date = date;
            }

            public Date getDate() {
                return date;
            }

            public void setDate(Date date) {
                this.date = date;
            }

            @Override
            public String toString() {
                return new StringJoiner(", ", Birth.class.getSimpleName() + "[", "]")
                        .add("date=" + date)
                        .toString();
            }

            // endregion Getters and Setters

        }

        // endregion Inner Classes

        // region Getters and Setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public Birth getBirth() {
            return birth;
        }

        public void setBirth(Birth birth) {
            this.birth = birth;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }
        @Override
        public String toString() {
            return new StringJoiner(", ", PlayerSportsAPIImport.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("firstname='" + firstname + "'")
                    .add("lastname='" + lastname + "'")
                    .add("birth=" + birth)
                    .add("nationality='" + nationality + "'")
                    .add("height='" + height + "'")
                    .add("weight='" + weight + "'")
                    .toString();
        }

        // endregion Getters and Setters

    }

    // region Getters and Setters

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Object> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Object> statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerSportsAPIImport.class.getSimpleName() + "[", "]")
                .add("player=" + player)
                .add("statistics=" + statistics)
                .toString();
    }

    // endregion Getters and Setters

}
