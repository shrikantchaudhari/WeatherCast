package com.testtriangle.weathercast.weather.data;

public class WeatherItem{
	private String description;
	private String main;
	private int id;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setMain(String main){
		this.main = main;
	}

	public String getMain(){
		return main;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"WeatherItem{" + 
			"description = '" + description + '\'' + 
			",main = '" + main + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
