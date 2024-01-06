package com.antonbondoc.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MainWeatherInfoVO {
    private Float temp;
    private Float feelsLike;
    private Float tempMin;
    private Float tempMax;
    private Integer pressure;
    private Integer humidity;
}
