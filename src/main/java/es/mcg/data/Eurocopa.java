package es.mcg.data;

import java.time.LocalDateTime;
import java.util.Date;

public class Eurocopa {
    private Integer match_id;
    private Date match_date;
    private Date kick_off;
    private Competition competition;
    private Season season;
    private HomeTeam home_team;
    private AwayTeam away_team;
    private Integer home_score;
    private Integer away_score;
    private MatchStatus match_status;
    private MatchStatus360 match_status_360;
    private LocalDateTime last_updated, last_updated360;
    private MetaData metadata;
    private Integer match_week;
    private CompetitionStage competition_stage;
    private Stadium stadium;
    private Referee referee;

    public Eurocopa()
    {
        this.match_id = 0;
        this.home_score = 0;
        this.away_score = 0;
        this.match_week = 0;
    }

    public Integer getMatch_id() 
    {
        return match_id;
    }

    public Date getMatch_date() 
    {
        return match_date;
    }

    public Date getKick_off() 
    {
        return kick_off;
    }

    public Competition getCompetition() 
    {
        return competition;
    }

    public Season getSeason() 
    {
        return season;
    }

    public HomeTeam getHome_team() 
    {
        return home_team;
    }

    public AwayTeam getAway_team() 
    {
        return away_team;
    }

    public Integer getHome_score() 
    {
        return home_score;
    }

    public Integer getAway_score() 
    {
        return away_score;
    }

    public MatchStatus getMatch_status() 
    {
        return match_status;
    }

    public MatchStatus360 getMatch_status_360() 
    {
        return match_status_360;
    }

    public LocalDateTime getLast_updated() 
    {
        return last_updated;
    }

    public LocalDateTime getLast_updated360() 
    {
        return last_updated360;
    }

    public MetaData getMetadata() 
    {
        return metadata;
    }

    public Integer getMatch_week() 
    {
        return match_week;
    }

    public CompetitionStage getCompetition_stage() 
    {
        return competition_stage;
    }

    public Stadium getStadium() 
    {
        return stadium;
    }

    public Referee getReferee() 
    {
        return referee;
    }

    public void setMatch_id(Integer match_id) 
    {
        this.match_id = match_id;
    }

    public void setMatch_date(Date match_date) 
    {
        this.match_date = match_date;
    }

    public void setKick_off(Date kick_off) 
    {
        this.kick_off = kick_off;
    }

    public void setCompetition(Competition competition) 
    {
        this.competition = competition;
    }

    public void setSeason(Season season) 
    {
        this.season = season;
    }

    public void setHome_team(HomeTeam home_team) 
    {
        this.home_team = home_team;
    }

    public void setAway_team(AwayTeam away_team) 
    {
        this.away_team = away_team;
    }

    public void setHome_score(Integer home_score) 
    {
        this.home_score = home_score;
    }

    public void setAway_score(Integer away_score) 
    {
        this.away_score = away_score;
    }

    public void setMatch_status(MatchStatus match_status) 
    {
        this.match_status = match_status;
    }

    public void setMatch_status_360(MatchStatus360 match_status_360) 
    {
        this.match_status_360 = match_status_360;
    }

    public void setLast_updated(LocalDateTime last_updated) 
    {
        this.last_updated = last_updated;
    }

    public void setLast_updated360(LocalDateTime last_updated360) 
    {
        this.last_updated360 = last_updated360;
    }

    public void setMetadata(MetaData metadata) 
    {
        this.metadata = metadata;
    }

    public void setMatch_week(Integer match_week) 
    {
        this.match_week = match_week;
    }

    public void setCompetition_stage(CompetitionStage competition_stage) 
    {
        this.competition_stage = competition_stage;
    }

    public void setStadium(Stadium stadium) 
    {
        this.stadium = stadium;
    }

    public void setReferee(Referee referee) 
    {
        this.referee = referee;
    }

    @Override
    public String toString() {
        return "Eurocopa [match_id=" + match_id + ", match_date=" + match_date + ", kick_off=" + kick_off
                + ", competition=" + competition + ", season=" + season + ", home_team=" + home_team + ", away_team="
                + away_team + ", home_score=" + home_score + ", away_score=" + away_score + ", match_status="
                + match_status + ", match_status_360=" + match_status_360 + ", last_updated=" + last_updated
                + ", last_updated360=" + last_updated360 + ", metadata=" + metadata + ", match_week=" + match_week
                + ", competition_stage=" + competition_stage + ", stadium=" + stadium + ", referee=" + referee + "]";
    }
    
}
