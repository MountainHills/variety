package com.antonbondoc.weather;

import com.antonbondoc.menu.weather.WeatherMainMenu;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class WeatherApplication {
    public WeatherApplication(Scanner scanner) {
        log.info("Booting weather application...");
        new WeatherMainMenu(scanner);
    }
}
