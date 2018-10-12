package com.testtriangle.weathercast.homescreen;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.testtriangle.weathercast.weather.WeatherRepository;
import com.testtriangle.weathercast.weather.data.WeatherForecastResponse;

public class HomeScreenViewModel extends AndroidViewModel {

    private WeatherRepository weatherRepository;

    private LiveData<WeatherForecastResponse> weatherForecastResponseLiveData;

    public HomeScreenViewModel(@NonNull Application application) {
        super(application);

        weatherRepository = new WeatherRepository();
    }

    /**
     * This function will call get forecast data API
     * @param latitude Double latitude
     * @param longitude Double longitude
     */
    public void getWeatherForecast(double latitude, double longitude) {
        weatherForecastResponseLiveData = weatherRepository.getWeatherForecast(latitude, longitude);
    }

    /**
     * This function will return data to observer in activity
     * @return LiveData
     */
    public LiveData<WeatherForecastResponse> getWeatherForecastResponseLiveData() {
        return weatherForecastResponseLiveData;
    }
}
