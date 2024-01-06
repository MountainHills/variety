package com.antonbondoc.weather;

import com.antonbondoc.weather.model.CurrentWeatherVO;
import com.antonbondoc.weather.service.WeatherService;
import com.antonbondoc.weather.service.WeatherServiceDefault;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExperimentalClass {

    private static WeatherService weatherService = new WeatherServiceDefault();

    public static void main(String[] args) {
        log.info("Calling weather service functionality.");
        CurrentWeatherVO currentWeatherVO = weatherService.getCurrentWeather();
        log.info("The current weather vo is: {}", currentWeatherVO);
    }
}
