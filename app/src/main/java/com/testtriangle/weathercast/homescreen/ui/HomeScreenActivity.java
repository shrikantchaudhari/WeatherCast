package com.testtriangle.weathercast.homescreen.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.testtriangle.weathercast.R;
import com.testtriangle.weathercast.homescreen.HomeScreenViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.testtriangle.weathercast.common.Constants.BROKEN_CLOUDS;
import static com.testtriangle.weathercast.common.Constants.CLEAR;
import static com.testtriangle.weathercast.common.Constants.CLEAR_SKY;
import static com.testtriangle.weathercast.common.Constants.CLOUDS;
import static com.testtriangle.weathercast.common.Constants.FEW_CLOUDS;
import static com.testtriangle.weathercast.common.Constants.FORECAST_DATE_FORMAT;
import static com.testtriangle.weathercast.common.Constants.FORECAST_DAY_FORMAT;
import static com.testtriangle.weathercast.common.Constants.SCATTERED_CLOUDS;

public class HomeScreenActivity extends AppCompatActivity implements LocationListener {


    HomeScreenViewModel homeScreenViewModel;
    private Unbinder unbinder;

    @BindView(R.id.iv_weather_status)
    ImageView ivWeatherStatus;

    @BindView(R.id.tv_location)
    TextView tvLocation;

    @BindView(R.id.tv_current_temp)
    TextView tvCurrentTemp;

    @BindView(R.id.tv_temp_status)
    TextView tvTempStatus;

    @BindView(R.id.tv_day_1)
    TextView tvDay1;

    @BindView(R.id.tv_day_2)
    TextView tvDay2;

    @BindView(R.id.tv_day_3)
    TextView tvDay3;

    @BindView(R.id.tv_day_4)
    TextView tvDay4;

    @BindView(R.id.tv_day_5)
    TextView tvDay5;

    @BindView(R.id.tv_weather_1)
    TextView tvWeather1;

    @BindView(R.id.tv_weather_2)
    TextView tvWeather2;

    @BindView(R.id.tv_weather_3)
    TextView tvWeather3;

    @BindView(R.id.tv_weather_4)
    TextView tvWeather4;

    @BindView(R.id.tv_weather_5)
    TextView tvWeather5;

    @BindView(R.id.rl_parent)
    RelativeLayout rlParent;

    @BindView(R.id.pb_load)
    ProgressBar pbLoad;

    @BindView(R.id.ll_main_content)
    LinearLayout llMainContent;

    private final int REQUEST_LOCATION_PERMISSION = 1;
    private LocationManager mLocationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        unbinder = ButterKnife.bind(this);

        homeScreenViewModel = ViewModelProviders.of(this).get(HomeScreenViewModel.class);

        requestLocationPermission();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @SuppressLint("MissingPermission")
    @AfterPermissionGranted(REQUEST_LOCATION_PERMISSION)
    public void requestLocationPermission() {
        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(this, perms)) {

            mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                homeScreenViewModel.getWeatherForecast(location.getLatitude(), location.getLongitude());

                observeWeatherData();

                isShowProgressBar(true);
            } else {
                mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            }


        } else {
            EasyPermissions.requestPermissions(this, "Please grant the location permission", REQUEST_LOCATION_PERMISSION, perms);
        }
    }

    public void observeWeatherData() {
        homeScreenViewModel.getWeatherForecastResponseLiveData().observe(this, weatherForecastResponse -> {

            isShowProgressBar(false);

            if (weatherForecastResponse != null) {

                try {
                    llMainContent.setVisibility(View.VISIBLE);
                    //Setting today's temp values
                    tvCurrentTemp.setText(getTempInCelsius(weatherForecastResponse.getList().get(0).getMain().getTemp()));
                    tvLocation.setText(weatherForecastResponse.getCity().getName());
                    tvTempStatus.setText(weatherForecastResponse.getList().get(0).getWeather().get(0).getDescription());
                    ivWeatherStatus.setImageResource(getWeatherStatusImage(weatherForecastResponse.getList().get(0).getWeather().get(0).getDescription()));
                    rlParent.setBackgroundResource(getWeatherMainTypeBackground(weatherForecastResponse.getList().get(0).getWeather().get(0).getMain()));

                    //Setting weekly temp values
                    tvDay1.setText(getForecastDay(weatherForecastResponse.getList().get(3).getDtTxt()));
                    tvWeather1.setText(getTempInCelsius(weatherForecastResponse.getList().get(3).getMain().getTemp()));
                    setWeatherStatusImageByDay(tvWeather1, weatherForecastResponse.getList().get(3).getWeather().get(0).getDescription());

                    tvDay2.setText(getForecastDay(weatherForecastResponse.getList().get(11).getDtTxt()));
                    tvWeather2.setText(getTempInCelsius(weatherForecastResponse.getList().get(11).getMain().getTemp()));
                    setWeatherStatusImageByDay(tvWeather2, weatherForecastResponse.getList().get(11).getWeather().get(0).getDescription());

                    tvDay3.setText(getForecastDay(weatherForecastResponse.getList().get(19).getDtTxt()));
                    tvWeather3.setText(getTempInCelsius(weatherForecastResponse.getList().get(19).getMain().getTemp()));
                    setWeatherStatusImageByDay(tvWeather3, weatherForecastResponse.getList().get(19).getWeather().get(0).getDescription());

                    tvDay4.setText(getForecastDay(weatherForecastResponse.getList().get(27).getDtTxt()));
                    tvWeather4.setText(getTempInCelsius(weatherForecastResponse.getList().get(27).getMain().getTemp()));
                    setWeatherStatusImageByDay(tvWeather4, weatherForecastResponse.getList().get(27).getWeather().get(0).getDescription());

                    tvDay5.setText(getForecastDay(weatherForecastResponse.getList().get(35).getDtTxt()));
                    tvWeather5.setText(getTempInCelsius(weatherForecastResponse.getList().get(35).getMain().getTemp()));
                    setWeatherStatusImageByDay(tvWeather5, weatherForecastResponse.getList().get(35).getWeather().get(0).getDescription());

                } catch (IndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            } else {
                Toast.makeText(this, getString(R.string.error_in_response), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * This function will return background of app based on weather main value
     *
     * @param main
     * @return
     */
    private int getWeatherMainTypeBackground(String main) {
        int drawable;
        switch (main) {

            case CLEAR:
                drawable = R.drawable.bg_clear_weather;
                break;
            case CLOUDS:
                drawable = R.drawable.bg_cloudy_weather;
                break;
            default:
                drawable = R.drawable.bg_clear_weather;
                break;
        }

        return drawable;
    }

    /**
     * This method will set small icons next to day wise weather
     *
     * @param tvWeather   TextView
     * @param description Weather Description
     */
    private void setWeatherStatusImageByDay(TextView tvWeather, String description) {

        int drawable;
        switch (description) {

            case CLEAR_SKY:
                drawable = R.drawable.ic_clear_sky_small;
                break;
            case BROKEN_CLOUDS:
                drawable = R.drawable.ic_broken_clouds_small;
                break;
            case SCATTERED_CLOUDS:
                drawable = R.drawable.ic_scattered_clouds_small;
                break;
            case FEW_CLOUDS:
                drawable = R.drawable.ic_few_clouds_small;
                break;
            default:
                drawable = R.drawable.ic_clear_sky_small;
                break;
        }

        tvWeather.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0);
    }

    /**
     * This method will return drawable based on weather description
     *
     * @param description
     * @return
     */
    private int getWeatherStatusImage(String description) {

        int drawable;
        switch (description) {

            case CLEAR_SKY:
                drawable = R.drawable.ic_clear_sky;
                break;
            case BROKEN_CLOUDS:
                drawable = R.drawable.ic_broken_clouds;
                break;
            case SCATTERED_CLOUDS:
                drawable = R.drawable.ic_scattered_clouds;
                break;
            case FEW_CLOUDS:
                drawable = R.drawable.ic_few_clouds;
                break;
            default:
                drawable = R.drawable.ic_clear_sky;
                break;
        }

        return drawable;
    }


    /**
     * This function will convert forecast date to day
     *
     * @param dtTxt : forecast date
     * @return : String day
     */
    private String getForecastDay(String dtTxt) {

        String day = null;

        try {

            SimpleDateFormat inFormat = new SimpleDateFormat(FORECAST_DATE_FORMAT);
            Date date = inFormat.parse(dtTxt);
            SimpleDateFormat outFormat = new SimpleDateFormat(FORECAST_DAY_FORMAT);
            day = outFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return day;
    }

    /**
     * This function will convert temp in Kelvin to Celsius
     *
     * @param temp - Temperature in Kelvin
     * @return - Temperature in Celsius
     */
    private String getTempInCelsius(double temp) {

        return (int) Math.round(temp - 273.15) + getString(R.string.degree_symbol);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void isShowProgressBar(boolean isShow) {
        if (isShow) {
            pbLoad.setVisibility(View.VISIBLE);
        } else {
            pbLoad.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        if (location != null) {
            homeScreenViewModel.getWeatherForecast(location.getLatitude(), location.getLongitude());

            observeWeatherData();

            isShowProgressBar(true);
        }

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
