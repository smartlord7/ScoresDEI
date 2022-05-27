package DataLayer.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "EventRedCard")
@Table(name = "EventRedCard")
public class EventRedCard extends Event{
    @OneToOne
    @JoinColumn(name = "id")
    private Player player;
}
