package BusinessLayer.Player;

import BusinessLayer.Player.DTO.PlayerCreateDTO;
import BusinessLayer.Player.DTO.PlayerSportsAPIImportDTO;
import BusinessLayer.Player.DTO.PlayerUpdateDTO;
import DataLayer.Model.Player;
import DataLayer.Model.Team;
import DataLayer.Repository.PlayerRepository;
import DataLayer.Repository.TeamRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.util.Arrays;
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

    @Value("${sports_api.api_key}")
    private String SPORTS_API_KEY;

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

        if (!dto.getTeamId().equals(t.getId())) {
            t.getPlayer().remove(p);
            Team t2 = teams.getById(dto.getTeamId());
            p.setTeam(t2);
            t2.getPlayer().add(p);
        }

        dto.setTeamName(p.getTeam().getTeamName());

        players.save(p);

        return dto;
    }

    public void importViaSportsAPI(Long league, Long season, Long page) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> data = Unirest.get(SPORTS_API_BASE_URL + "/players")
                .queryString("league", league)
                .queryString("season", season)
                .queryString("page", page)
                .header("x-apisports-key", SPORTS_API_KEY)
                .asString();
        String playersStr = new JSONObject(new JSONObject(data).get("body").toString()).get("response").toString();
        List<PlayerCreateDTO> playerList = new ArrayList<PlayerCreateDTO>();
        new JSONArray(playersStr).forEach(o -> {
            PlayerTranslator.toCreateDTO(new Gson().fromJson(o.toString(), PlayerSportsAPIImportDTO.class), teams);
        });

    }

    // endregion Public Methods

}
