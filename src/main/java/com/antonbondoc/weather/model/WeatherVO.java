package com.antonbondoc.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherVO {
    private String main;
    private String description;
}
