package com.antonbondoc.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
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
