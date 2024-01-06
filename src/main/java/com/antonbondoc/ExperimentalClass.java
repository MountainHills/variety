package com.antonbondoc;

import java.util.Locale;

public class ExperimentalClass {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println("The current locale is: " + locale);
        System.out.println("The current country code is: " + locale.getCountry());
        System.out.println("The current display name is: " + locale.getDisplayName());
    }
}
