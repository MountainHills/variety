package com.antonbondoc.weather;

import com.antonbondoc.menu.weather.WeatherMainMenu;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeatherApplication {
    public WeatherApplication() {
        log.info("Booting weather application...");
        new WeatherMainMenu();
    }
}
