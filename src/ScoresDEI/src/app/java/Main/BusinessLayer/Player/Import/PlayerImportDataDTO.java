package Main.BusinessLayer.Player.Import;

import java.util.StringJoiner;

public class PlayerImportDataDTO {
    private Long league;
    private Long season;
    private Long page;

    public PlayerImportDataDTO() {
    }

    public PlayerImportDataDTO(Long league, Long season, Long page) {
        this.league = league;
        this.season = season;
        this.page = page;
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

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerImportDataDTO.class.getSimpleName() + "[", "]")
                .add("league=" + league)
                .add("season=" + season)
                .add("page=" + page)
                .toString();
    }
}
