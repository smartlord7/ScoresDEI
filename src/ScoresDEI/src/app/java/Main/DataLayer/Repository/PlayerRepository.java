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

package Main.DataLayer.Repository;

import Main.DataLayer.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT p, (SELECT COUNT(eg) " +
            "FROM EventGoal eg " +
            "WHERE p.id = eg.player.id AND " +
            "eg.approved IS TRUE) AS goals " +
            "FROM Player p " +
            "WHERE " +
            "(SELECT COUNT(eg) " +
            "FROM EventGoal eg " +
            "WHERE p.id = eg.player.id AND " +
            "eg.approved IS TRUE) >= ALL (SELECT COUNT(eg2) " +
            "FROM EventGoal eg2 " +
            "WHERE eg2.approved IS TRUE " +
            "GROUP BY eg2.player.id)")
    List<Object>[] getBestScorer();

}
