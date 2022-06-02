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

package Main.BusinessLayer.Team.Import;

import Main.BusinessLayer.Player.Import.PlayerImportResultDTO;

import java.util.StringJoiner;

public class TeamImportResultDTO {

    // region Private Properties

    private Long importedTeams;
    private String source;

    // endregion Private Properties

    // region Constructors

    public TeamImportResultDTO() {
    }

    public TeamImportResultDTO(Long importedTeams, String source) {
        this.importedTeams = importedTeams;
        this.source = source;
    }

    // endregion Constructors

    // region Getters and Setters

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

    // endregion Getters and Setters

}
