package BusinessLayer.Team.Import;

import BusinessLayer.Player.Import.PlayerImportResultDTO;

import java.util.StringJoiner;

public class TeamImportResultDTO {
    private Long importedTeams;
    private String source;

    public TeamImportResultDTO() {
    }

    public TeamImportResultDTO(Long importedTeams, String source) {
        this.importedTeams = importedTeams;
        this.source = source;
    }

    public Long getImportedTeams() {
        return importedTeams;
    }

    public void setImportedTeams(Long importedTeams) {
        this.importedTeams = importedTeams;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerImportResultDTO.class.getSimpleName() + "[", "]")
                .add("importedPlayers=" + importedTeams)
                .add("source='" + source + "'")
                .toString();
    }
}
