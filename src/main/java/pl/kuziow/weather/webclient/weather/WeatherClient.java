package pl.kuziow.weather.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kuziow.weather.model.WeatherDto;
import pl.kuziow.weather.webclient.weather.dto.OpenWeatherWeatherDto;

@Component
public class WeatherClient {


    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String apiKey = "c25e1c14ef71f2601f0fb9a7366e843f";
    private RestTemplate restTemplate = new RestTemplate();
//
//    public String getWeatherForCity(String city) {
//
//        return getForObject("weather?q={city}&appid={apiKey}&units=metrics", String.class,
//                city, apiKey);
//    }
    // zwracamy stringa

//    public OpenWeatherWeatherDto getWeatherForCity(String city) {
//
//        return getForObject("weather?q={city}&appid={apiKey}&units=metrics",
//                OpenWeatherWeatherDto.class,
//                city, apiKey);
//    }
    //zwracamy brzydki obiekt OpenWeatherWeatherDto

    public WeatherDto getWeatherForCity(String city) {

        OpenWeatherWeatherDto openWeatherWeatherDto = getForObject("weather?q={city}&appid={apiKey}&units=metrics",
                OpenWeatherWeatherDto.class,
                city, apiKey);

        return WeatherDto.builder()
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .windSspeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }

    public String getForecast(double lat, double lon) {
        return getForObject("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}", String.class,
                lat, lon, apiKey);
    }

//    public String getForObject(String url, Class<String> responseType, Object... objects) {
//        return restTemplate.getForObject(WEATHER_URL + url,
//                responseType, objects);
//    }
    //tylko dla klasy String


    //z typem generycznym
    public <T> T getForObject(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
