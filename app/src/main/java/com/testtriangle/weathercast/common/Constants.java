/**
 * @file Constants.java
 * @brief This Class includes various constants that are needed through out the application.
 */

package com.testtriangle.weathercast.common;

public class Constants {

    public static final String APP_ID = "66d0c320f553e322b26f2e31e7bd8309";

    // WEB API METHODS
    public static final String BASE_URL = "https://api.openweathermap.org";
    public static final String GET_FORECAST = "/data/2.5/forecast";

    public static final String FORECAST_DATE_FORMAT = "yyyy-mm-dd hh:mm:ss";
    public static final String FORECAST_DAY_FORMAT = "EEEE";

    //Weather Status
    public static final String CLEAR_SKY = "clear sky";
    public static final String BROKEN_CLOUDS = "broken clouds";
    public static final String SCATTERED_CLOUDS = "scattered clouds";
    public static final String FEW_CLOUDS = "few clouds";
    public static final String CLEAR = "Clear";
    public static final String CLOUDS = "Clouds";

}
