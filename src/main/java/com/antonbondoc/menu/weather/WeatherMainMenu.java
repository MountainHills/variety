package com.antonbondoc.menu.weather;

import java.util.Scanner;

public class WeatherMainMenu {
    public WeatherMainMenu() {
        System.out.println("======= Welcome to Weather Application =======");
        System.out.println("Note: This app uses Apache HttpClient, Jackson, and OpenWeather API.");
        openAppSelection();
    }

    private void openAppSelection() {
        Scanner scan = new Scanner(System.in);

        main:
        while (true) {

            displayAvailableApps();

            String choice = scan.next().toUpperCase();
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

        scan.close();
    }

    private void displayCurrentWeather() {

    }

    private void displayAvailableApps() {
        System.out.println("=== Available Information ===");
        System.out.println("[A] Current Weather");
        System.out.println("[B] Air Pollution Status");
        System.out.println("[Q] Back to Main Menu");
        System.out.print("==! Choose an option: ");
    }
}