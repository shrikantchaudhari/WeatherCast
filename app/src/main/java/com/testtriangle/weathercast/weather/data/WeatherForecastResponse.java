package com.testtriangle.weathercast.weather.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherForecastResponse {

    @SerializedName("list")
    private ArrayList<ListItem> list;

    @SerializedName("city")
    private City city;

    public ArrayList<ListItem> getList() {
        return list;
    }

    public void setList(ArrayList<ListItem> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
