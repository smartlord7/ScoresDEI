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
    Long getTeamByTeamName(String teamName);
}
