package es.mcg.data;

public class Season {
    private Integer season_id;
    private String season_name;

    public Season()
    {
        this.season_id = 0;
        this.season_name = "";
    }

    public Integer getSeason_id() 
    {
        return season_id;
    }

    public String getSeason_name() 
    {
        return season_name;
    }

    public void setSeason_id(Integer season_id) 
    {
        this.season_id = season_id;
    }

    public void setSeason_name(String season_name) 
    {
        this.season_name = season_name;
    }
}
