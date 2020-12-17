package pl.kuziow.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kuziow.weather.model.WeatherDto;
import pl.kuziow.weather.webclient.weather.WeatherClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather() {

//        String response = weatherClient.getWeatherForCity("Warszawa");
//
//        log.info(response);
//
//        String forecast = weatherClient.getForecast(52.23, 21.01);
//        log.info(forecast);
//        return null;
        //to jest kod jak zwracalibyśmy Stringa
        return weatherClient.getWeatherForCity("Warszawa");
    }


}
