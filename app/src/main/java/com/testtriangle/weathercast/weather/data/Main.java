package com.testtriangle.weathercast.weather.data;

public class Main{
	private double temp;

	public void setTemp(double temp){
		this.temp = temp;
	}

	public double getTemp(){
		return temp;
	}

	@Override
 	public String toString(){
		return 
			"Main{" + 
			"temp = '" + temp + '\'' + 
			"}";
		}
}
