package BusinessLayer.Player.DTO;

import BusinessLayer.Base.DTO.BaseEntityDTO;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class PlayerSportsAPIImportDTO implements BaseEntityDTO {
    private Player player;
    private List<Object> statistics;

    public static class Player {
        private String name;
        private String firstname;
        private String lastname;
        private Birth birth;
        private String nationality;
        private String height;
        private String weight;

        public static class Birth {
            private Date date;

            public Birth() {
            }

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
        }

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
            return new StringJoiner(", ", PlayerSportsAPIImportDTO.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("firstname='" + firstname + "'")
                    .add("lastname='" + lastname + "'")
                    .add("birth=" + birth)
                    .add("nationality='" + nationality + "'")
                    .add("height='" + height + "'")
                    .add("weight='" + weight + "'")
                    .toString();
        }
    }

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
        return new StringJoiner(", ", PlayerSportsAPIImportDTO.class.getSimpleName() + "[", "]")
                .add("player=" + player)
                .add("statistics=" + statistics)
                .toString();
    }
}
