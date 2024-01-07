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

        while (true) {
            Scanner scan = new Scanner(System.in);
            displayAvailableApps();

            String choice = scan.next().toUpperCase();
            switch (choice) {
                case "A":
                    scan.close();
                    new WeatherApplication();
                    break;
                case "Q":
                    System.out.println("Thank you for using Variety Application");
                    System.exit(0);
                default:
                    scan.close();
                    System.out.println("Invalid option, please try again!");
            }
        }
    }

    private void displayAvailableApps() {
        System.out.println("=== Available Applications ===");
        System.out.println("[A] Weather Application");
        System.out.println("[Q] Exit Application");
        System.out.print("==! Choose an option: ");
    }
}
