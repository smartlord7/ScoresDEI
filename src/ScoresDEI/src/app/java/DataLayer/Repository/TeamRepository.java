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

package DataLayer.Repository;

import DataLayer.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT t.id, " +
            "t.teamName,  " +
            "( " +
            " SELECT COUNT(g) " +
            " FROM Game g " +
            " WHERE (g.teamA.id = t.id OR " +
            "    g.teamB.id = t.id) AND " +
            "   (SELECT COUNT(*) " +
            "   FROM EventEndGame eg " +
            "   WHERE eg.game.id = g.id AND" +
            "   eg.approved IS TRUE) = 1 " +
            ") AS games,  " +
            "( " +
            " SELECT COUNT(g) " +
            " FROM Game g " +
            " WHERE (g.teamA.id = t.id AND " +
            "   g.scoreA > g.scoreB OR " +
            "   g.teamB.id = t.id AND " +
            "   g.scoreB > g.scoreA) AND " +
            "   (SELECT COUNT(*) " +
            "   FROM EventEndGame eg " +
            "   WHERE eg.game.id = g.id AND" +
            "   eg.approved IS TRUE) = 1 " +
            ") AS victories, " +
            "( " +
            " SELECT COUNT(*) " +
            " FROM Game g " +
            " WHERE (g.teamA.id = t.id AND " +
            "   g.scoreA = g.scoreB OR " +
            "   g.teamB.id = t.id AND " +
            "   g.scoreB = g.scoreA) AND " +
            "   (SELECT COUNT(*) " +
            "   FROM EventEndGame eg" +
            "   WHERE eg.game.id = g.id AND" +
            "   eg.approved IS TRUE) = 1 " +
            ") AS draws, " +
            "( " +
            "SELECT COUNT(*) " +
            "FROM Game g " +
            "    WHERE  (g.teamA.id = t.id AND " +
            "   g.scoreA < g.scoreB OR " +
            "   g.teamB.id = t.id AND " +
            "   g.scoreB < g.scoreA) AND " +
            "   (SELECT COUNT(*) " +
            "   FROM EventEndGame eg " +
            "   WHERE eg.game.id = g.id AND" +
            "   eg.approved IS TRUE) = 1 " +
            ") AS losses " +
            "FROM Team t")
    List<Object>[] getAllDetailed();
    Team getFirstByTeamName(String teamName);
}
