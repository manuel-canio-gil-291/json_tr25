package es.mcg.data;

public class Stadium {
    private Integer id;
    private String name;
    private Country country;

    public Stadium()
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

    public Country getCountry() 
    {
        return country;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setCountry(Country country) 
    {
        this.country = country;
    }
}
