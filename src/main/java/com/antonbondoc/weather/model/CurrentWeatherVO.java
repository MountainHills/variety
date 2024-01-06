package com.antonbondoc.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CurrentWeatherVO {
    private List<WeatherVO> weather;
    private MainWeatherInfoVO main;
}
