package BusinessLayer.Team;

import BusinessLayer.Player.Import.PlayerImportResultDTO;
import BusinessLayer.Player.Import.PlayerSportsAPIImport;
import BusinessLayer.Player.PlayerTranslator;
import BusinessLayer.Team.DTO.TeamCreateDTO;
import BusinessLayer.Team.DTO.TeamUpdateDTO;
import BusinessLayer.Team.Import.TeamImportResultDTO;
import BusinessLayer.Team.Import.TeamSportsAPIImport;
import DataLayer.Model.Attachment;
import DataLayer.Model.Player;
import DataLayer.Model.Team;
import DataLayer.Repository.AttachmentRepository;
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
public class TeamWriter {

    // region Private Properties

    @Autowired
    private TeamRepository teams;

    @Autowired
    private AttachmentRepository attachments;

    @Value("${sports_api.base_url}")
    private String SPORTS_API_BASE_URL;

    // endregion Private Properties

    // region Public Methods

    @Transactional
    public TeamCreateDTO create(TeamCreateDTO dto) {
        Team t;

        t = TeamTranslator.toModel(dto);
        if (dto.getLogoId() != null) {
            Attachment a = attachments.getById(dto.getLogoId());
            t.setLogo(a);
        }
        teams.save(t);

        dto.setId(t.getId());

        return dto;
    }

    @Transactional
    public TeamUpdateDTO deleteById(long id) {
        teams.deleteById(id);

        return TeamTranslator.toUpdateDTO(id);
    }

    @Transactional
    public TeamUpdateDTO update(TeamUpdateDTO dto) {
       Team t;

       t = teams.getById(dto.getId());
        if (dto.getLogoId() != null) {
            TeamTranslator.applyChanges(t, dto);
            Attachment a = attachments.getById(dto.getLogoId());
            t.setLogo(a);
        }

       teams.save(t);

       return dto;
    }

    @Transactional
    public TeamImportResultDTO importViaSportsAPI(String keyAPI, long league, long season) {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> data = null;
        try {
            data = Unirest.get(SPORTS_API_BASE_URL + "/teams")
                    .queryString("league", league)
                    .queryString("season", season)
                    .header("x-apisports-key", keyAPI)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();

            return null;
        }
        String teamsStr = new JSONObject(
                new JSONObject(data).get("body").toString())
                .get("response")
                .toString();
        List<Team> teamList = new ArrayList<Team>();
        new JSONArray(teamsStr).forEach(o -> teamList.add(TeamTranslator.toModel(
                new Gson().fromJson(
                        new JSONObject(o.toString()).get("team").toString(),
                TeamSportsAPIImport.class))));

        teams.saveAll(teamList);

        return new TeamImportResultDTO(
                (long) teamList.size(),
                SPORTS_API_BASE_URL + "/teams"
        );
    }

    // endregion Public Methods

}
