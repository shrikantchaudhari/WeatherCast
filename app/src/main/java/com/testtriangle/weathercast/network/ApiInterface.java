/**
 * @file ApiInterface.java
 * @brief This is the api interface class, it will contain all the Api call references
 * @author Kavita
 * @date 29/06/2018
 */
package com.testtriangle.weathercast.network;

import com.testtriangle.weathercast.common.Constants;
import com.testtriangle.weathercast.weather.data.WeatherForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET(Constants.GET_FORECAST)
    Call<WeatherForecastResponse> getForecastData(@Query("lat") double latitude,
                                                  @Query("lon") double longitude,
                                                  @Query("appid") String appId);


}
