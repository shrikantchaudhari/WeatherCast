package com.testtriangle.weathercast.weather.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListItem {

    private int dt;

    @SerializedName("dt_txt")
    private String dtTxt;

    private List<WeatherItem> weather;

    private Main main;

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getDt() {
        return dt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setWeather(List<WeatherItem> weather) {
        this.weather = weather;
    }

    public List<WeatherItem> getWeather() {
        return weather;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return main;
    }

    @Override
    public String toString() {
        return
                "ListItem{" +
                        "dt = '" + dt + '\'' +
                        ",dt_txt = '" + dtTxt + '\'' +
                        ",weather = '" + weather + '\'' +
                        ",main = '" + main + '\'' +
                        "}";
    }
}