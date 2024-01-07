package com.antonbondoc.menu;

import com.antonbondoc.weather.WeatherApplication;

import java.util.Scanner;

public class VarietyMainMenu {
    public VarietyMainMenu() {
        System.out.println("======= Welcome to Variety Application =======");
        System.out.println("Note: This program is an assortment of short applications");
        System.out.println("Note: Have fun and enjoy your stay!");
        openAppSelection();
    }

    private void openAppSelection() {
        Scanner scanner = new Scanner(System.in);

        main:
        while (true) {
            displayAvailableApps();
            String choice = scanner.next().toUpperCase();
            switch (choice) {
                case "A":
                    new WeatherApplication(scanner);
                    break;
                case "Q":
                    System.out.println("Thank you for using Variety Application");
                    break main;
                default:
                    scanner.close();
                    System.out.println("Invalid option, please try again!");
            }
        }

        scanner.close();
    }

    private void displayAvailableApps() {
        System.out.println("=== Available Applications ===");
        System.out.println("[A] Weather Application");
        System.out.println("[Q] Exit Application");
        System.out.print("==! Choose an option: ");
    }
}
