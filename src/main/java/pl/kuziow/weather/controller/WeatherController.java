package pl.kuziow.weather.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kuziow.weather.model.WeatherDto;
import pl.kuziow.weather.service.WeatherService;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDto getWeather(){
        return weatherService.getWeather();
    }
}
