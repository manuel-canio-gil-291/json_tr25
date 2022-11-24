package es.mcg.data;

public class AwayTeam {
    private Integer away_team_id;
    private String away_team_name, away_team_gender, away_team_group;
    private Country country;
    private Managers managers;

    public AwayTeam()
    {
        this.away_team_id = 0;
        this.away_team_name = "";
        this.away_team_gender = "";
        this.away_team_group = "";
    }

    public Integer getAway_team_id() 
    {
        return away_team_id;
    }

    public String getAway_team_name() 
    {
        return away_team_name;
    }

    public String getAway_team_gender() 
    {
        return away_team_gender;
    }

    public String getAway_team_group() 
    {
        return away_team_group;
    }

    public Country getCountry() 
    {
        return country;
    }

    public Managers getManagers() 
    {
        return managers;
    }

    public void setAway_team_id(Integer away_team_id) 
    {
        this.away_team_id = away_team_id;
    }

    public void setAway_team_name(String away_team_name) 
    {
        this.away_team_name = away_team_name;
    }

    public void setAway_team_gender(String away_team_gender) 
    {
        this.away_team_gender = away_team_gender;
    }

    public void setAway_team_group(String away_team_group) 
    {
        this.away_team_group = away_team_group;
    }

    public void setCountry(Country country) 
    {
        this.country = country;
    }

    public void setManagers(Managers managers) 
    {
        this.managers = managers;
    }
    
}
