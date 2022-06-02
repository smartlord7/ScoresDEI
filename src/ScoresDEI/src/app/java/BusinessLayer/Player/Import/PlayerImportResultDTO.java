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
