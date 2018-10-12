package com.testtriangle.weathercast.weather;

import android.arch.lifecycle.MutableLiveData;

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

    /**
     * This function will give call to get Weather Forecast data API
     *
     * @param latitude  double latitude
     * @param longitude double longitude
     * @return LiveData
     */
    public MutableLiveData<WeatherForecastResponse> getWeatherForecast(double latitude, double longitude) {

        final MutableLiveData<WeatherForecastResponse> data = new MutableLiveData<>();

        Call<WeatherForecastResponse> call = apiService.getForecastData(latitude, longitude, APP_ID);
        call.enqueue(new Callback<WeatherForecastResponse>() {
            @Override
            public void onResponse(Call<WeatherForecastResponse> call, Response<WeatherForecastResponse> response) {

                WeatherForecastResponse weatherForecastResponse = response.body();
                if (weatherForecastResponse != null) {
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
