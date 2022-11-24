package es.mcg.data;

public class HomeTeam {
    private Integer home_team_id;
    private String home_team_name, home_team_gender, home_team_group;
    private Country country;
    private Managers managers;

    public HomeTeam()
    {
        this.home_team_id = 0;
        this.home_team_name = "";
        this.home_team_gender = "";
        this.home_team_group = "";
    }

    public Integer getHome_team_id() 
    {
        return home_team_id;
    }

    public String getHome_team_name() 
    {
        return home_team_name;
    }

    public String getHome_team_gender() 
    {
        return home_team_gender;
    }

    public String getHome_team_group() 
    {
        return home_team_group;
    }

    public Country getCountry() 
    {
        return country;
    }

    public Managers getManagers() 
    {
        return managers;
    }

    public void setHome_team_id(Integer home_team_id) 
    {
        this.home_team_id = home_team_id;
    }

    public void setHome_team_name(String home_team_name) 
    {
        this.home_team_name = home_team_name;
    }

    public void setHome_team_gender(String home_team_gender) 
    {
        this.home_team_gender = home_team_gender;
    }

    public void setHome_team_group(String home_team_group) 
    {
        this.home_team_group = home_team_group;
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
