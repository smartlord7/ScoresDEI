package Main.BusinessLayer.Team.DTO;

import java.util.StringJoiner;

public class TeamImportDataDTO {
    private Long league;
    private Long season;

    public TeamImportDataDTO() {
    }

    public TeamImportDataDTO(Long league, Long season) {
        this.league = league;
        this.season = season;
    }

    public Long getLeague() {
        return league;
    }

    public void setLeague(Long league) {
        this.league = league;
    }

    public Long getSeason() {
        return season;
    }

    public void setSeason(Long season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Main.BusinessLayer.Player.Import.PlayerImportDataDTO.class.getSimpleName() + "[", "]")
                .add("league=" + league)
                .add("season=" + season)
                .toString();
    }
}
