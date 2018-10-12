package com.testtriangle.weathercast.weather;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.testtriangle.weathercast.network.ApiClient;
import com.testtriangle.weathercast.network.ApiInterface;
import com.testtriangle.weathercast.weather.data.WeatherForecastResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.testtriangle.weathercast.common.Constants.APP_ID;

public class WeatherRepository {

    private ApiInterface apiService;

    public WeatherRepository() {

        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public MutableLiveData<WeatherForecastResponse> getWeatherForecast(double latitude, double longitude) {

        final MutableLiveData<WeatherForecastResponse> data = new MutableLiveData<>();

        Call<WeatherForecastResponse> call = apiService.getForecastData(latitude, longitude, APP_ID);
        call.enqueue(new Callback<WeatherForecastResponse>() {
            @Override
            public void onResponse(Call<WeatherForecastResponse> call, Response<WeatherForecastResponse> response) {

                WeatherForecastResponse weatherForecastResponse = response.body();
                if(weatherForecastResponse != null){
                    data.setValue(weatherForecastResponse);
                }

            }

            @Override
            public void onFailure(Call<WeatherForecastResponse> call, Throwable t) {

                data.setValue(null);
            }
        });

        return data;
    }
}
