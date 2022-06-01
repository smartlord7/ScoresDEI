package BusinessLayer.Player.Import;

import java.util.StringJoiner;

public class PlayerImportResultDTO {

    // region Private Properties

    private Long importedPlayers;
    private String source;

    // endregion Private Properties

    // region Constructors

    public PlayerImportResultDTO() {
    }

    public PlayerImportResultDTO(Long importedPlayers, String source) {
        this.importedPlayers = importedPlayers;
        this.source = source;
    }

    // endregion Constructors

    // region Getters and Setters

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

    // endregion Getters and Setters


}
