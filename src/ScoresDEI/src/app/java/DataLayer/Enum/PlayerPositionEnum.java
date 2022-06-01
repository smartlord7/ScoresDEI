package DataLayer.Enum;

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

    public static PlayerPositionEnum fromString(String str) {
        return switch (str.toLowerCase()) {
            case "goalkeeper" -> GK;
            case "defender" -> CB;
            case "midfielder" -> CM;
            default -> ST;
        };
    }
}
