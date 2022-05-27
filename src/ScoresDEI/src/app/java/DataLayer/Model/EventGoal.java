package DataLayer.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "EventGoal")
@Table(name = "EventGoal")
public class EventGoal extends Event{
    @OneToOne
    @JoinColumn("id")
    private Player player;
}
