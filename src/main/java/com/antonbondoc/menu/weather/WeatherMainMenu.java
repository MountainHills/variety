package com.antonbondoc.menu.weather;

import com.antonbondoc.weather.model.CurrentWeatherVO;
import com.antonbondoc.weather.model.MainWeatherInfoVO;
import com.antonbondoc.weather.model.WeatherVO;
import com.antonbondoc.weather.service.WeatherService;
import com.antonbondoc.weather.service.WeatherServiceDefault;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class WeatherMainMenu {

    private final static WeatherService weatherService = new WeatherServiceDefault();

    public WeatherMainMenu(Scanner scanner) {
        System.out.println("======= Welcome to Weather Application =======");
        System.out.println("Note: This app uses Apache HttpClient, Jackson, and OpenWeather API.");
        openAppSelection(scanner);
    }

    private void openAppSelection(Scanner scanner) {
        main:
        while (true) {
            displayAvailableApps();
            String choice = scanner.next();
            switch (choice) {
                case "A":
                    displayCurrentWeather();
                    break;
                case "Q":
                    System.out.println("Thank you for using the Weather Application");
                    break main;
                default:
                    System.out.println("Invalid option, please try again!");
            }
        }
    }

    private void displayAvailableApps() {
        System.out.println("=== Available Information ===");
        System.out.println("[A] Current Weather");
        System.out.println("[B] Air Pollution Status");
        System.out.println("[Q] Back to Main Menu");
        System.out.print("==! Choose an option: ");
    }

    private void displayCurrentWeather() {
        System.out.println("== Current Weather Information ==");
        final CurrentWeatherVO currentWeatherVO = weatherService.getCurrentWeather();

        if (currentWeatherVO == null) {
            System.out.println("Didn't get current weather information.");
            return;
        }

        final WeatherVO weather = currentWeatherVO.getWeather().get(0);
        System.out.println("#== General Weather Forecast ==");
        System.out.println("Status: " + weather.getMain());
        System.out.println("Description: " + weather.getDescription());

        final MainWeatherInfoVO main = currentWeatherVO.getMain();
        System.out.println("#== More Information ==");
        System.out.println("Description: " + main.getTemp());
        System.out.println("Feels like: " + main.getFeelsLike());
        System.out.println("Minimum Temperature: " + main.getTempMin());
        System.out.println("Max Temperature: " + main.getTempMax());
        System.out.println("Atmospheric Pressure: " + main.getPressure());
        System.out.println("Humidity: " + main.getHumidity());
    }

}
