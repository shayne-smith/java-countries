package com.lambdaschool.countrysearch;

public class Country
{
    // fields
    private String name;
    private long population;
    private long landMass;
    private long medianAge;

    public Country(
        String name,
        long population,
        long landMass,
        long medianAge)
    {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getLandMass()
    {
        return landMass;
    }

    public void setLandMass(long landMass)
    {
        this.landMass = landMass;
    }

    public long getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(long medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" +
            ", name='" + name + '\'' +
            ", population=" + population +
            ", landMass=" + landMass +
            ", medianAge=" + medianAge +
            '}';
    }
}
