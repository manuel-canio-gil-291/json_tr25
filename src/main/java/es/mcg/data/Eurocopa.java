package es.mcg.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Eurocopa {
    private Integer match_id;
    private LocalDate match_date;
    private LocalTime kick_off;
    private Competition competition;
    private Season season;
    private HomeTeam home_team;
    private AwayTeam away_team;
    private Integer home_score;
    private Integer away_score;
    private String match_status, match_status_360;
    private LocalDateTime last_updated, last_updated360;
    private MetaData metadata;
    private Integer match_week;
    private CompetitionStage competition_stage;
    private Stadium stadium;
    private Referee referee;
}
