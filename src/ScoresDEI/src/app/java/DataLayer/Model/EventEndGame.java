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

package DataLayer.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "EventEndGame")
@Table(name = "EventEndGame")
public class EventEndGame extends Event{

    // region Constructor

    public EventEndGame() {
    }

    public EventEndGame(Date occurrenceTime, String description) {
        super(occurrenceTime, description);
    }

    // endregion Constructor

}
