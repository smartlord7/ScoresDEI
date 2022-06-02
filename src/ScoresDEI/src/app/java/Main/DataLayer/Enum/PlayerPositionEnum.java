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

package Main.DataLayer.Enum;

/**
 * Enum that has all the player avaliable positions.
 */
public enum PlayerPositionEnum {
    GK,
    RB,
    LB,
    RWB,
    LWB,
    CB,
    CDM,
    CM,
    CAM,
    RM,
    LM,
    RW,
    LW,
    RF,
    LF,
    CF,
    ST;

    /**
     * Function that associates positions to it's abbreviation.
     * @param str is the position
     * @return the abbreviation
     */
    public static PlayerPositionEnum fromString(String str) {
        return switch (str.toLowerCase()) {
            case "goalkeeper" -> GK;
            case "defender" -> CB;
            case "midfielder" -> CM;
            default -> ST;
        };
    }
}
