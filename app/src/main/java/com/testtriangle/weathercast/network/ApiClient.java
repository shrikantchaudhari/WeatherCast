/**
 * @file ApiClient.java
 * @brief This class will provide retrofit instance.
 * @author Shrikant
 * @date 11/10/2018
 */
package com.testtriangle.weathercast.network;

import com.testtriangle.weathercast.common.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    /**
     * This method returns retrofit client instance
     *
     * @return Retrofit object
     */
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
