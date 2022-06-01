package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerSportsAPIImportDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;
import DataLayer.Model.Team;
import DataLayer.Repository.PlayerRepository;
import DataLayer.Repository.TeamRepository;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerWriter {

    // region Private Properties

    @Autowired
    private PlayerRepository players;

    @Autowired
    private TeamRepository teams;

    @Value("${sports_api.base_url}")
    private String SPORTS_API_BASE_URL;

    // endregion Private Properties

    // region Public Methods

    @Transactional
    public PlayerCreateDTO create(PlayerCreateDTO dto) {
        Player p = PlayerTranslator.toModel(dto);
        p.setTeam(teams.getById(dto.getTeamId()));
        p.getTeam().getPlayer().add(p);
        players.save(p);
        dto.setId(p.getId());

        return dto;
    }

    @Transactional
    public PlayerUpdateDTO deleteById(long id) {
        players.deleteById(id);

        return PlayerTranslator.toUpdateDTO(id);
    }

    @Transactional
    public PlayerUpdateDTO update(PlayerUpdateDTO dto) {
        Player p = players.getById(dto.getId());
        PlayerTranslator.applyChanges(p, dto);
        Team t = p.getTeam();

        if (t != null && !dto.getTeamId().equals(t.getId())) {
            t.getPlayer().remove(p);
            Team t2 = teams.getById(dto.getTeamId());
            p.setTeam(t2);
            t2.getPlayer().add(p);
            dto.setTeamName(p.getTeam().getTeamName());
        }

        players.save(p);

        return dto;
    }

    @Transactional
    public int importViaSportsAPI(String keyAPI, long league, long season, long page) {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> data = null;
        try {
            data = Unirest.get(SPORTS_API_BASE_URL + "/players")
                    .queryString("league", league)
                    .queryString("season", season)
                    .queryString("page", page)
                    .header("x-apisports-key", keyAPI)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();

            return 0;
        }
        String playersStr = new JSONObject(new JSONObject(data).get("body").toString()).get("response").toString();
        List<Player> playerList = new ArrayList<Player>();
        new JSONArray(playersStr).forEach(o -> {
            playerList.add(PlayerTranslator.toModel(new Gson().fromJson(o.toString(), PlayerSportsAPIImportDTO.class), teams));
        });

        players.saveAll(playerList);

        return playerList.size();
    }

    // endregion Public Methods

}
