package pl.kuziow.weather.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {

    private float temperature;
    private int pressure;
    private int humidity;
    private float windSspeed;}
