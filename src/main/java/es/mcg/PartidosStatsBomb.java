package es.mcg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import es.mcg.data.Competition;
import es.mcg.data.Country;
import es.mcg.data.Eurocopa;
import es.mcg.data.HomeTeam;
import es.mcg.data.Season;

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
        Eurocopa eurocopa = null;
        try
        {
            file = new File("43.json");
            fileContent = FileUtils.readFileToString(file, PartidosStatsBomb.ENCODE);
            fileWriter = new FileWriter(new File("partidos.txt"));
            printWriter = new PrintWriter(fileWriter);

            JsonNode eurocopaJsonNode = Json.mapper().readTree(fileContent);

            if(eurocopaJsonNode.isArray())
            {
                JsonNode eurocopaArrayJsonNode = (ArrayNode) eurocopaJsonNode;

                final Iterator<JsonNode> eurocopaIterator = eurocopaArrayJsonNode.elements();
                while(eurocopaIterator.hasNext())
                {
                    eurocopa = new Eurocopa();
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
                        JsonNode seasonNode = eurocopaDataJsonNode.get("seasonNode");
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
                        }
                    }
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
