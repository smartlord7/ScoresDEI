package BusinessLayer.Player.DTO;

import java.util.StringJoiner;

public class PlayerImportResultDTO {
    private Long importedPlayers;
    private String source;

    public PlayerImportResultDTO() {
    }

    public PlayerImportResultDTO(Long importedPlayers, String source) {
        this.importedPlayers = importedPlayers;
        this.source = source;
    }

    public Long getImportedPlayers() {
        return importedPlayers;
    }

    public void setImportedPlayers(Long importedPlayers) {
        this.importedPlayers = importedPlayers;
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
                .add("importedPlayers=" + importedPlayers)
                .add("source='" + source + "'")
                .toString();
    }
}
