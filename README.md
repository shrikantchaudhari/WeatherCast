# WeatherCast
This is the simple weather app which shows 5 days weather forecast data for the given location.

## Features

In the current version, we support for the following functionality
                                                    
- Fetching latitude and longitude for the user's current location.
- Showing 5 days weather forecast data.

## Release

Please find the application released on below URL

[WeatherCast v1.0](https://github.com/shrikantchaudhari/WeatherCast/releases/tag/WeatherCast_1.0)

## Steps to Install the app

- Goto above release page.
- Under "Assets" section, you will see [weathercast_1.0.apk](https://github.com/shrikantchaudhari/WeatherCast/releases/download/WeatherCast_1.0/weathercast_1.0.apk), click on that it will download an application on your device.
- Once apk get downloaded, install the application and you are ready to use this app.

##  Enhancement
Right now this application supports really limited functionality. In future, if we want to enhance this application then we can consider the following features.

### New Feature
- We can provide a facility through which a user can get weather update for multiple locations.
- We can show more weather details on the current screen. Like humidity, UV index, wind speed, sunrise and sunset time etc.
- We can set a notification channel, which will alert the user for certain weather conditions like heavy rain, thunderstorm etc.
- We can show a weather news for selected locations.
- We can integrate social network channel through which user will be able to share weather updates. Like twitter, facebook etc.
- We can create a small widget which will give abstract weather information on users device home screen.
- We can give some configuration options like modify the temperature unit, the interval at which we should fetch new data.

### Known Issues
- You can not change the location once set for the first time.
- Instead of mapping API data individually in the UI element we can use Data binding.
- Error handling is pending if the user does not allow the app to use there location.