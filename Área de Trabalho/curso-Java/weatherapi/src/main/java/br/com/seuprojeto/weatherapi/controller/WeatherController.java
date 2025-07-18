package br.com.seuprojeto.weatherapi.controller;

import br.com.seuprojeto.weatherapi.model.WeatherResponse;
import br.com.seuprojeto.weatherapi.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    public WeatherResponse getWeatherForecast(@RequestParam double latitude, @RequestParam double longitude) {
        return weatherService.getWeatherForecast(latitude, longitude);
    }

    @GetMapping("/alerts")
    public String getWeatherAlerts(@RequestParam double latitude, @RequestParam double longitude) {
        return weatherService.getWeatherAlerts(latitude, longitude);
    }

    @GetMapping("/history")
    public WeatherResponse getWeatherHistory(@RequestParam double latitude, @RequestParam double longitude, @RequestParam String date) {
        return weatherService.getWeatherHistory(latitude, longitude, date);
    }

    @GetMapping("/compare")
    public String compareWeather(@RequestParam double lat1, @RequestParam double lon1, @RequestParam double lat2, @RequestParam double lon2) {
        return weatherService.compareWeather(lat1, lon1, lat2, lon2);
    }

    @GetMapping("/sector-analysis")
    public String getSectorAnalysis(@RequestParam double latitude, @RequestParam double longitude, @RequestParam String sector) {
        return weatherService.getSectorAnalysis(latitude, longitude, sector);
    }

    @GetMapping("/recommendations")
    public String getRecommendations(@RequestParam double latitude, @RequestParam double longitude) {
        return weatherService.getRecommendations(latitude, longitude);
    }

    @GetMapping("/dashboard")
    public String getWeatherDashboard(@RequestParam double latitude, @RequestParam double longitude) {
        return weatherService.getWeatherDashboard(latitude, longitude);
    }
}
