package es.mcg.data;

public class CompetitionStage {
    private Integer id;
    private String name;

    public CompetitionStage()
    {
        this.id = 0;
        this.name = "";
    }

    public Integer getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
}
