package es.mcg.data;

import java.util.Date;

public class Managers {
    private Integer id;
    private String name, nickname;
    private Date dob;
    private Country country;

    public Managers()
    {
        this.id = 0;
        this.name = "";
        this.nickname = "";
    }

    public Integer getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public String getNickname() 
    {
        return nickname;
    }

    public Date getDob() 
    {
        return dob;
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

    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public void setDob(Date dob) 
    {
        this.dob = dob;
    }

    public void setCountry(Country country) 
    {
        this.country = country;
    }
}
