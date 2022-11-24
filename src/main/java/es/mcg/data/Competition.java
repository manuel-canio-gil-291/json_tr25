package es.mcg.data;

public class Competition {
    private Integer competition_id;
    private String country_name, competition_name;

    public Competition()
    {
        this.competition_id = 0;
        this.country_name = "";
        this.competition_name = "";
    }

    public Integer getCompetition_id() 
    {
        return competition_id;
    }

    public String getCountry_name() 
    {
        return country_name;
    }

    public String getCompetition_name() 
    {
        return competition_name;
    }

    public void setCompetition_id(Integer competition_id) 
    {
        this.competition_id = competition_id;
    }

    public void setCountry_name(String country_name) 
    {
        this.country_name = country_name;
    }

    public void setCompetition_name(String competition_name) 
    {
        this.competition_name = competition_name;
    }
    
}
