package es.mcg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import es.mcg.data.AwayTeam;
import es.mcg.data.Competition;
import es.mcg.data.CompetitionStage;
import es.mcg.data.Country;
import es.mcg.data.Eurocopa;
import es.mcg.data.HomeTeam;
import es.mcg.data.Managers;
import es.mcg.data.MatchStatus;
import es.mcg.data.MatchStatus360;
import es.mcg.data.MetaData;
import es.mcg.data.Referee;
import es.mcg.data.Season;
import es.mcg.data.Stadium;

public class PartidosStatsBomb {
    private static final String ENCODE = "UTF-8";
    private static final Logger LOGGER = LogManager.getLogger();

    public static class Json
    {
        private static ObjectMapper MAPPER;

        public static ObjectMapper mapper()
        {
            if(Json.MAPPER == null)
            {
                Json.MAPPER = Json.createJson();
            }

            return Json.MAPPER;
        }

        public static ObjectMapper createJson()
        {
            return new ObjectMapper();
        }
    }

    public static void main(String[] args) {
        File file = null;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        String fileContent;
        List<Eurocopa> datosEurocopa = null;
        try
        {
            file = new File("43.json");
            fileContent = FileUtils.readFileToString(file, PartidosStatsBomb.ENCODE);
            fileWriter = new FileWriter(new File("partidos.txt"));
            printWriter = new PrintWriter(fileWriter);
            datosEurocopa = new ArrayList<Eurocopa>();
            JsonNode eurocopaJsonNode = Json.mapper().readTree(fileContent);

            if(eurocopaJsonNode.isArray())
            {
                JsonNode eurocopaArrayJsonNode = (ArrayNode) eurocopaJsonNode;

                final Iterator<JsonNode> eurocopaIterator = eurocopaArrayJsonNode.elements();
                while(eurocopaIterator.hasNext())
                {
                    Eurocopa eurocopa = new Eurocopa();
                    final JsonNode eurocopaDataJsonNode = eurocopaIterator.next();
                    if(eurocopaDataJsonNode.has("match_id"))
                    {
                        final JsonNode matchIdNode = eurocopaDataJsonNode.get("match_id");
                        eurocopa.setMatch_id(Integer.parseInt(matchIdNode.asText()));
                    }
                    if(eurocopaDataJsonNode.has("match_date"))
                    {
                        final JsonNode matchDateNode = eurocopaDataJsonNode.get("match_date");
                        String pattern = "yyyy-MM-dd";
                        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                        eurocopa.setMatch_date(dateFormat.parse(matchDateNode.asText()));
                    }
                    if(eurocopaDataJsonNode.has("kick_off"))
                    {
                        final JsonNode kickOffNode = eurocopaDataJsonNode.get("kick_off");
                        String pattern = "HH:mm:ss.SSS";
                        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                        eurocopa.setKick_off(dateFormat.parse(kickOffNode.asText()));
                    }
                    if(eurocopaDataJsonNode.has("competition"))
                    {
                        Competition competition = new Competition();
                        JsonNode competitionNode = eurocopaDataJsonNode.get("competition");
                        if(competitionNode.isObject())
                        {
                            JsonNode competitionObjectNode = (ObjectNode) competitionNode;
                            if(competitionObjectNode.has("competition_id"))
                            {
                                final JsonNode competitionIdNode = competitionObjectNode.get("competition_id");
                                competition.setCompetition_id(Integer.parseInt(competitionIdNode.asText()));
                            }
                            if(competitionObjectNode.has("contry_name"))
                            {
                                final JsonNode countryNameNode = competitionObjectNode.get("country_name");
                                competition.setCountry_name(countryNameNode.asText());
                            }
                            if(competitionObjectNode.has("competition_name"))
                            {
                                final JsonNode competitionNameNode = competitionObjectNode.get("competition_name");
                                competition.setCompetition_name(competitionNameNode.asText());
                            }
                        }
                        eurocopa.setCompetition(competition);
                    }
                    if(eurocopaDataJsonNode.has("season"))
                    {
                        Season season = new Season();
                        JsonNode seasonNode = eurocopaDataJsonNode.get("season");
                        if(seasonNode.isObject())
                        {
                            JsonNode seasonObjectNode = (ObjectNode) seasonNode;
                            if(seasonObjectNode.has("season_id"))
                            {
                                final JsonNode seasonIdNode = seasonObjectNode.get("season_id");
                                season.setSeason_id(Integer.parseInt(seasonIdNode.asText()));
                            }
                            if(seasonObjectNode.has("season_name"))
                            {
                                final JsonNode seasonNameNode = seasonObjectNode.get("season_name");
                                season.setSeason_name(seasonNameNode.asText());
                            }
                        }
                        eurocopa.setSeason(season);
                    }
                    if(eurocopaDataJsonNode.has("home_team"))
                    {
                        HomeTeam homeTeam = new HomeTeam();
                        JsonNode homeTeamNode = eurocopaDataJsonNode.get("home_team");
                        if(homeTeamNode.isObject())
                        {
                            JsonNode homeTeamObjectNode = (ObjectNode) homeTeamNode;
                            if(homeTeamObjectNode.has("home_team_id"))
                            {
                                final JsonNode homeTeamIdNode = homeTeamObjectNode.get("home_team_id");
                                homeTeam.setHome_team_id(Integer.parseInt(homeTeamIdNode.asText()));
                            }
                            if(homeTeamObjectNode.has("home_team_name"))
                            {
                                final JsonNode homeTeamNameNode = homeTeamObjectNode.get("home_team_name");
                                homeTeam.setHome_team_name(homeTeamNameNode.asText());
                            }
                            if(homeTeamObjectNode.has("home_team_geder"))
                            {
                                final JsonNode homeTeamGenderNode = homeTeamObjectNode.get("home_team_gender");
                                homeTeam.setHome_team_gender(homeTeamGenderNode.asText());
                            }
                            if(homeTeamObjectNode.has("home_team_group"))
                            {
                                final JsonNode homeTeamGroupNode = homeTeamObjectNode.get("home_team_group");
                                homeTeam.setHome_team_group(homeTeamGroupNode.asText());
                            }
                            if(homeTeamObjectNode.has("country"))
                            {
                                Country country = new Country();
                                JsonNode countryNode = homeTeamObjectNode.get("country");
                                if(countryNode.isObject())
                                {
                                    JsonNode countryObjectNode = (ObjectNode) countryNode;
                                    if(countryObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = countryObjectNode.get("id");
                                        country.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(countryObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = countryObjectNode.get("name");
                                        country.setName(nameNode.asText());
                                    }
                                }
                                homeTeam.setCountry(country);
                            }
                            if(homeTeamObjectNode.has("managers"))
                            {
                                Managers managers = new Managers();
                                JsonNode managersNode = homeTeamObjectNode.get("managers");
                                if(managersNode.isArray())
                                {
                                    JsonNode managersArrayNode = (ArrayNode) managersNode;

                                    final Iterator<JsonNode> managersIterator = managersArrayNode.elements();
                                    while(managersIterator.hasNext())
                                    {
                                        final JsonNode managersDataJsonNode = managersIterator.next();
                                        if(managersDataJsonNode.has("id"))
                                        {
                                            final JsonNode idNode = managersDataJsonNode.get("id");
                                            managers.setId(Integer.parseInt(idNode.asText()));
                                        }
                                        if(managersDataJsonNode.has("name"))
                                        {
                                            final JsonNode nameNode = managersDataJsonNode.get("name");
                                            managers.setName(nameNode.asText());
                                        }
                                        if(managersDataJsonNode.has("nickname"))
                                        {
                                            final JsonNode nicknameNode = managersDataJsonNode.get("nickname");
                                            if(nicknameNode.asText() == null)
                                            {
                                                managers.setNickname("none");
                                            }
                                            else
                                            {
                                                managers.setNickname(nicknameNode.asText());
                                            }
                                        }
                                        if(managersDataJsonNode.has("dob"))
                                        {
                                            final JsonNode dobNode = managersDataJsonNode.get("dob");
                                            String pattern = "yyyy-MM-dd";
                                            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                                            managers.setDob(dateFormat.parse(dobNode.asText()));
                                        }
                                        if(managersDataJsonNode.has("country"))
                                        {
                                            Country country = new Country();
                                            JsonNode countryNode = managersDataJsonNode.get("country");

                                            if(countryNode.isObject())
                                            {
                                                JsonNode countryObjectNode = (ObjectNode) countryNode;
                                                if(countryObjectNode.has("id"))
                                                {
                                                    final JsonNode idNode = countryObjectNode.get("id");
                                                    country.setId(Integer.parseInt(idNode.asText()));
                                                }
                                                if(countryObjectNode.has("name"))
                                                {
                                                    final JsonNode nameNode = countryObjectNode.get("name");
                                                    country.setName(nameNode.asText());
                                                }
                                            }
                                            managers.setCountry(country);
                                        }
                                    }
                                }
                                homeTeam.setManagers(managers);
                            }
                        }
                        eurocopa.setHome_team(homeTeam);
                    }
                    if(eurocopaDataJsonNode.has("away_team"))
                    {
                        AwayTeam awayTeam = new AwayTeam();
                        JsonNode awayTeamNode = eurocopaDataJsonNode.get("away_team");

                        if(awayTeamNode.isObject())
                        {
                            JsonNode awayTeamObjectNode = (ObjectNode) awayTeamNode;
                            if(awayTeamObjectNode.has("away_team_id"))
                            {
                                final JsonNode awayTeamIdNode = awayTeamObjectNode.get("away_team_id");
                                awayTeam.setAway_team_id(Integer.parseInt(awayTeamIdNode.asText()));
                            }
                            if(awayTeamObjectNode.has("away_team_name"))
                            {
                                final JsonNode awayTeamNameNode = awayTeamObjectNode.get("away_team_name");
                                awayTeam.setAway_team_name(awayTeamNameNode.asText());
                            }
                            if(awayTeamObjectNode.has("away_team_gender"))
                            {
                                final JsonNode awayTeamGenderNode = awayTeamObjectNode.get("away_team_gender");
                                awayTeam.setAway_team_gender(awayTeamGenderNode.asText());
                            }
                            if(awayTeamObjectNode.has("away_team_group"))
                            {
                                final JsonNode awayTeamGroupNode = awayTeamObjectNode.get("away_team_group");
                                awayTeam.setAway_team_group(awayTeamGroupNode.asText());
                            }
                            if(awayTeamObjectNode.has("country"))
                            {
                                Country country = new Country();

                                JsonNode countryNode = awayTeamObjectNode.get("country");
                                if(countryNode.isObject())
                                {
                                    JsonNode countryObjectNode = (ObjectNode) countryNode;
                                    if(countryObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = countryObjectNode.get("id");
                                        country.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(countryObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = countryObjectNode.get("name");
                                        country.setName(nameNode.asText());
                                    }
                                }
                                awayTeam.setCountry(country);
                            }
                            if(awayTeamObjectNode.has("managers"))
                            {
                                Managers managers = new Managers();

                                JsonNode managersNode = awayTeamObjectNode.get("managers");
                                if(managersNode.isArray())
                                {
                                    JsonNode managersArrayNode = (ArrayNode) managersNode;

                                    final Iterator<JsonNode> managersIterator = managersArrayNode.elements();
                                    while(managersIterator.hasNext())
                                    {
                                        final JsonNode managersDataJsonNode = managersIterator.next();
                                        if(managersDataJsonNode.has("id"))
                                        {
                                            final JsonNode idNode = managersDataJsonNode.get("id");
                                            managers.setId(Integer.parseInt(idNode.asText()));
                                        }
                                        if(managersDataJsonNode.has("name"))
                                        {
                                            final JsonNode nameNode = managersDataJsonNode.get("name");
                                            managers.setName(nameNode.asText());
                                        }
                                        if(managersDataJsonNode.has("nickname"))
                                        {
                                            final JsonNode nicknameNode = managersDataJsonNode.get("nickname");
                                            if(nicknameNode.asText() == null)
                                            {
                                                managers.setNickname("none");
                                            }
                                            else
                                            {
                                                managers.setNickname(nicknameNode.asText());
                                            }
                                        }
                                        if(managersDataJsonNode.has("dob"))
                                        {
                                            final JsonNode dobNode = managersDataJsonNode.get("dob");
                                            String pattern = "yyyy-MM-dd";
                                            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                                            managers.setDob(dateFormat.parse(dobNode.asText()));
                                        }
                                        if(managersDataJsonNode.has("country"))
                                        {
                                            Country country = new Country();
                                            JsonNode countryNode = managersDataJsonNode.get("country");

                                            if(countryNode.isObject())
                                            {
                                                JsonNode countryObjectNode = (ObjectNode) countryNode;
                                                if(countryObjectNode.has("id"))
                                                {
                                                    final JsonNode idNode = countryObjectNode.get("id");
                                                    country.setId(Integer.parseInt(idNode.asText()));
                                                }
                                                if(countryObjectNode.has("name"))
                                                {
                                                    final JsonNode nameNode = countryObjectNode.get("name");
                                                    country.setName(nameNode.asText());
                                                }
                                            }
                                            managers.setCountry(country);
                                        }
                                    }
                                }
                                awayTeam.setManagers(managers);
                            }
                        }
                        eurocopa.setAway_team(awayTeam);
                    }
                    if(eurocopaDataJsonNode.has("home_score"))
                    {
                        final JsonNode homeScoreNode = eurocopaDataJsonNode.get("home_score");
                        eurocopa.setHome_score(Integer.parseInt(homeScoreNode.asText()));
                    }
                    if(eurocopaDataJsonNode.has("away_score"))
                    {
                        final JsonNode awayScoreNode = eurocopaDataJsonNode.get("away_score");
                        eurocopa.setAway_score(Integer.parseInt(awayScoreNode.asText()));
                    }
                    if(eurocopaDataJsonNode.has("match_status"))
                    {
                        final JsonNode matchStatusNode = eurocopaDataJsonNode.get("match_status");
                        if(matchStatusNode.asText().equals("available"))
                        {
                            eurocopa.setMatch_status(MatchStatus.AVAILABLE);
                        }
                        else if(matchStatusNode.asText().equals("deleted"))
                        {
                            eurocopa.setMatch_status(MatchStatus.DELETED);
                        }
                        else if(matchStatusNode.asText().equals("scheduled"))
                        {
                            eurocopa.setMatch_status(MatchStatus.SCHEDULED);
                        }
                        else
                        {
                            eurocopa.setMatch_status(null);
                        }
                    }
                    if(eurocopaDataJsonNode.has("match_status_360"))
                    {
                        final JsonNode matchStatus360Node = eurocopaDataJsonNode.get("match_status_360");
                        if(matchStatus360Node.asText().equals("available"))
                        {
                            eurocopa.setMatch_status_360(MatchStatus360.AVAILABLE);
                        }
                        else if(matchStatus360Node.asText().equals("deleted"))
                        {
                            eurocopa.setMatch_status_360(MatchStatus360.DELETED);
                        }
                        else if(matchStatus360Node.asText().equals("scheduled"))
                        {
                            eurocopa.setMatch_status_360(MatchStatus360.SCHEDULED);
                        }
                        else
                        {
                            eurocopa.setMatch_status_360(null);
                        }
                    }
                    if(eurocopaDataJsonNode.has("last_updated"))
                    {
                        final JsonNode lastUpdatedNode = eurocopaDataJsonNode.get("last_updated");
                        String datetime = lastUpdatedNode.asText();
                        eurocopa.setLast_updated(LocalDateTime.parse(datetime));
                    }
                    if(eurocopaDataJsonNode.has("last_updated_360"))
                    {
                        final JsonNode lastUpdated360Node = eurocopaDataJsonNode.get("last_updated_360");
                        String datetime = lastUpdated360Node.asText();
                        eurocopa.setLast_updated360(LocalDateTime.parse(datetime));
                    }
                    if(eurocopaDataJsonNode.has("metadata"))
                    {
                        MetaData metaData = new MetaData();

                        JsonNode metadataNode = eurocopaDataJsonNode.get("metadata");
                        if(metadataNode.isObject())
                        {
                            JsonNode metadataObjectNode = (ObjectNode) metadataNode;
                            if(metadataObjectNode.has("data_version"))
                            {
                                final JsonNode dataVersionNode = metadataObjectNode.get("data_version");
                                metaData.setData_version(dataVersionNode.asText());
                            }
                            if(metadataObjectNode.has("shot_fidelity_version"))
                            {
                                final JsonNode shotFidelityVersionNode = metadataObjectNode.get("shot_fidelity_version");
                                metaData.setShot_fidelity_version(shotFidelityVersionNode.asText());
                            }
                            if(metadataObjectNode.has("xy_fidelity_version"))
                            {
                                final JsonNode xyFidelityVersionNode = metadataObjectNode.get("xy_fidelity_version");
                                metaData.setXy_fidelity_version(xyFidelityVersionNode.asText());
                            }
                        }
                        eurocopa.setMetadata(metaData);
                    }
                    if(eurocopaDataJsonNode.has("match_week"))
                    {
                        final JsonNode matchWeekNode = eurocopaDataJsonNode.get("match_week");
                        eurocopa.setMatch_week(Integer.parseInt(matchWeekNode.asText()));
                    }
                    if(eurocopaDataJsonNode.has("competition_stage"))
                    {
                        CompetitionStage competitionStage = new CompetitionStage();

                        JsonNode competitionStageNode = eurocopaDataJsonNode.get("competition_stage");
                        if(competitionStageNode.isObject())
                        {
                            JsonNode competitionStageObjectNode = (ObjectNode) competitionStageNode;
                            if(competitionStageObjectNode.has("id"))
                            {
                                final JsonNode idNode = competitionStageObjectNode.get("id");
                                competitionStage.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(competitionStageObjectNode.has("name"))
                            {
                                final JsonNode nameNode = competitionStageObjectNode.get("name");
                                competitionStage.setName(nameNode.asText());
                            }
                        }
                        eurocopa.setCompetition_stage(competitionStage);
                    }
                    if(eurocopaDataJsonNode.has("stadium"))
                    {
                        Stadium stadium = new Stadium();

                        JsonNode stadiumNode = eurocopaDataJsonNode.get("stadium");
                        if(stadiumNode.isObject())
                        {
                            JsonNode stadiumObjectNode = (ObjectNode) stadiumNode;
                            if(stadiumObjectNode.has("id"))
                            {
                                final JsonNode idNode = stadiumObjectNode.get("id");
                                stadium.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(stadiumObjectNode.has("name"))
                            {
                                final JsonNode nameNode = stadiumObjectNode.get("name");
                                stadium.setName(nameNode.asText());
                            }
                            if(stadiumObjectNode.has("country"))
                            {
                                Country country = new Country();

                                JsonNode countryNode = stadiumObjectNode.get("country");
                                if(countryNode.isObject())
                                {
                                    JsonNode countryObjectNode = (ObjectNode) countryNode;
                                    if(countryObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = countryObjectNode.get("id");
                                        country.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(countryObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = countryObjectNode.get("name");
                                        country.setName(nameNode.asText());
                                    }
                                }
                                stadium.setCountry(country);
                            }
                        }
                        eurocopa.setStadium(stadium);
                    }
                    if(eurocopaDataJsonNode.has("referee"))
                    {
                        Referee referee = new Referee();

                        JsonNode refereeNode = eurocopaDataJsonNode.get("referee");
                        if(refereeNode.isObject())
                        {
                            JsonNode refereeObjectNode = (ObjectNode) refereeNode;
                            if(refereeObjectNode.has("id"))
                            {
                                final JsonNode idNode = refereeObjectNode.get("id");
                                referee.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(refereeObjectNode.has("name"))
                            {
                                final JsonNode nameNode = refereeObjectNode.get("name");
                                referee.setName(nameNode.asText());
                            }
                            if(refereeObjectNode.has("country"))
                            {
                                Country country = new Country();

                                JsonNode countryNode = refereeObjectNode.get("country");
                                if(countryNode.isObject())
                                {
                                    JsonNode countryObjectNode = (ObjectNode) countryNode;
                                    if(countryObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = countryObjectNode.get("id");
                                        country.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(countryObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = countryObjectNode.get("name");
                                        country.setName(nameNode.asText());
                                    }
                                }
                                referee.setCountry(country);
                            }
                        }
                        eurocopa.setReferee(referee);
                    }
                    datosEurocopa.add(eurocopa);
                }
            }
            printWriter.println("Nombre de los equipos que jugaron la final de la Eurocopa 2020:");
            for(int i = 0; i < datosEurocopa.size(); i++)
            {
                if(datosEurocopa.get(i).getCompetition_stage().getName().equals("Final"))
                {
                    printWriter.println(datosEurocopa.get(i).getHome_team().getHome_team_name());
                    printWriter.println(datosEurocopa.get(i).getAway_team().getAway_team_name());
                }
            }
            printWriter.println("Entrenadores cuya nacionalidad no coincide con el pais que representa:");
            for(int i = 0; i < datosEurocopa.size(); i++)
            {
                if(datosEurocopa.get(i).getHome_team().getHome_team_name() 
                != datosEurocopa.get(i).getHome_team().getManagers().getCountry().getName())
                {
                    printWriter.println(datosEurocopa.get(i).getHome_team().getManagers().getName());
                }
                if(datosEurocopa.get(i).getAway_team().getAway_team_name()
                != datosEurocopa.get(i).getAway_team().getManagers().getName())
                {
                    printWriter.println(datosEurocopa.get(i).getAway_team().getManagers().getName());
                }
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            printWriter.println("Nombres de los equipos que jugaron el partido despues del 1 de julio de 2021:");
            for(int i = 0; i < datosEurocopa.size(); i++) 
            {
                if(datosEurocopa.get(i).getMatch_date().after(dateFormat.parse("2021-07-01")))
                {
                    printWriter.println(datosEurocopa.get(i).getHome_team().getHome_team_name());
                    printWriter.println(datosEurocopa.get(i).getAway_team().getAway_team_name());
                }
            }
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        catch(ParseException parseException)
        {
            parseException.printStackTrace();
        }
    }
}
