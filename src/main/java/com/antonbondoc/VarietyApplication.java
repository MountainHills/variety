package com.antonbondoc;


import com.antonbondoc.menu.VarietyMainMenu;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VarietyApplication {
    public static void main(String[] args) {
        log.info("Booting up Variety Application...");
        new VarietyMainMenu();
    }
}