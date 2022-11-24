package es.mcg.data;

public class Country {
    private Integer id;
    private String name;

    public Country()
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
