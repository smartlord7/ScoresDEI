package DataLayer.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "EventYellowCard")
@Table(name = "EventYellowCard")
public class EventYellowCard extends Event{
    @OneToOne
    @JoinColumn("id")
    private Player player;
}
