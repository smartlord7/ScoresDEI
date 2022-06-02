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

package Main.DataLayer.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EventGoal")
@Table(name = "EventGoal")
public class EventGoal extends Event{

    // region Private Properties

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private Player player;

    // endregion Private Properties

    // region Constructors

    public EventGoal() {
        super();
    }

    public EventGoal(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    // endregion Constructors

    // region Getters and Setters

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // endregion Getters and Setters

}
