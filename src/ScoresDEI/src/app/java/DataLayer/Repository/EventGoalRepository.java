package DataLayer.Repository;

import DataLayer.Model.EventGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventGoalRepository extends JpaRepository<EventGoal, Long> {
    
    Integer getGoalsByGame(Long gameId);
}
