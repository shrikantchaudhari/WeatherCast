package com.testtriangle.weathercast.weather.data;

public class City {


    private String country;

    private String name;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "City{" +
                        "country = '" + country + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}